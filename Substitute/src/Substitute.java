import java.util.*;
public class Substitute {
	public int getValue(String key, String code) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < key.length(); ++i) {
			map.put(key.charAt(i), (i+1)%10);
		}
		int ret = 0;
		for (int i = 0; i < code.length(); ++i) {
			if (map.containsKey(code.charAt(i))) {
				ret = ret * 10 + map.get(code.charAt(i));
			}
		}
		return ret;
	}
}