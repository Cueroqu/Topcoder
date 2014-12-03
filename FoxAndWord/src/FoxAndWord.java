import java.util.*;
public class FoxAndWord {
	public int howManyPairs(String[] words) {
		int i, j, ret = 0;
		String tmp;
		Set<String> garbage = new HashSet<String>();
		Set<String> record = new HashSet<String>(Arrays.asList(words));
		for (i = 0; i < words.length - 1; ++i) {
			record.remove(words[i]);
			StringBuilder head = new StringBuilder(words[i]);
			garbage.clear();
			for (j = 1; j < words[i].length(); ++j) {
				tmp = head.substring(j)+head.substring(0, j);
				for (String s : record) {
					if (garbage.contains(s)) continue;
					if (s.length() != tmp.length()) garbage.add(s);
					if (s.equals(tmp)) {
						++ret;
						garbage.add(s);
					}
				}
			}
		}
		return ret;
	}
	
}