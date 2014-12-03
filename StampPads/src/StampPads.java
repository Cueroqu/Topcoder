import java.util.*;
public class StampPads {
	class WrapInt {
		int ret;
	}
	
	public int bestCombo2(String[] pads, String[] wishlist) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>(), originLists;
		List<Integer> list = null;
		for (int i = 0; i < pads.length; ++i) {
			list = new ArrayList<Integer>();
			list.add(i);
			lists.add(list);
		}
		Set<String> wishset = new HashSet<String>();
		for (String s : wishlist) wishset.add(s);
		String[][] padsColors = new String[pads.length][];
		int i;
		for (i = 0; i < pads.length; ++i) {
			padsColors[i] = pads[i].split(" ");
		}
		while (!lists.isEmpty()) {
			originLists = lists;
			lists = new ArrayList<List<Integer>>();
			for (List<Integer> l : originLists) {
				if (hasAllColor(padsColors, l, wishset)) return l.size();
				for (i = l.get(l.size()-1) + 1; i < pads.length; ++i) {
					list = new ArrayList<Integer>();
					list.addAll(l);
					list.add(i);
					lists.add(list);
				}
			}
		}
		return -1;
	}
	
	public boolean hasAllColor(String[][] padsColors, List<Integer> list, Set<String> wishset) {
		Set<String> record = new HashSet<String>();
		for (Integer i : list) {
			for (String s : padsColors[i]) {
				if (wishset.contains(s)) record.add(s);
			}
		}
		return record.size() == wishset.size();
	}
	
	public int bestCombo(String[] pads, String[] wishlist) {
		Map<String, Integer> colorCnt = new HashMap<String, Integer>();
		Set<String> stringRecord = new HashSet<String>();
		Set<String> dict = new HashSet<String>();
		for (String s : wishlist) {
			stringRecord.add(s);
			dict.add(s);
		}
		WrapInt ans = new WrapInt();
		ans.ret = -1;
		dfs(pads, 0, colorCnt, stringRecord, dict, ans, 0);
		return ans.ret;
	}
	
	public void dfs(String[] pads, int index, Map<String, Integer> colorCnt, Set<String> stringRecord, Set<String> dict, WrapInt ans, int selected) {
		if (index == pads.length) {
			return;
		}
		if (ans.ret > 0 && selected >= ans.ret) return;
		dfs(pads, index+1, colorCnt, stringRecord, dict, ans, selected);
		
		String[] tmp = pads[index].split(" ");
		for (String s : tmp) {
			Integer value = colorCnt.get(s);
			if (value == null || value == 0) {
				colorCnt.put(s, 1);
				stringRecord.remove(s);
			} else {
				colorCnt.put(s, value+1);
			}
		}
		if (stringRecord.size() == 0 && (selected+1 < ans.ret || ans.ret < 0)) ans.ret = selected+1;
		dfs(pads, index+1, colorCnt, stringRecord, dict, ans, selected+1);
		for (String s : tmp) {
			colorCnt.put(s, colorCnt.get(s)-1);
			if (colorCnt.get(s) == 0 && dict.contains(s)) stringRecord.add(s);
		}
	}
	
	public static void main(String[] args) {
		StampPads sp = new StampPads();
		String[] pads = {"a i y d o", "t s k g e", "j u w i k", "u k l s j", "q s a c y",
				 "q m d x a", "m s l h r", "s x q l n", "u r j s k", "e w v d p",
				 "o l a b q", "f z g a m", "o g k b a", "c h g k t", "z v s n x",
				 "z n b w c", "h p o u k", "t z o x m", "a w i v z", "u t v m y"};
		String[] wishlist = {"x", "b", "u", "c", "h", "j", "t", "v", "d", "g",
				 "k", "w", "y", "z", "a", "i", "m", "l", "n", "e"};
		System.out.println(sp.bestCombo2(pads, wishlist));
	}
}