import java.util.*;
public class StringTrain {
	public String buildTrain(String[] cars) {
		StringBuilder sb = new StringBuilder();
		sb.append(cars[0]);
		boolean[] used = new boolean[cars.length];
		used[0] = true;
		int prefixLen, i, j, k, tmpIdx = 0;
		for (;;) {
			i = tmpIdx + 1;
			tmpIdx = -1;
			prefixLen = 0;
			for (; i < cars.length; ++i) {
				if (used[i] || cars[i].length() <= prefixLen) continue;
				for (j = Math.max(1, sb.length() - cars[i].length()+1); j < sb.length()-prefixLen; ++j) {
					for (k = j; k < sb.length(); ++k) {
						if (cars[i].charAt(k-j) != sb.charAt(k)) break;
					}
					if (k == sb.length()) {
						tmpIdx = i;
						prefixLen = sb.length()-j;
					}
				}
			}
			if (tmpIdx == -1) break;
			used[tmpIdx] = true;
			sb.append(cars[tmpIdx].substring(prefixLen));
		}
		return GetAns(sb);
	}
	
	public String GetAns(StringBuilder sb) {
		Set<Character> set = new HashSet<Character>();
		char[] array = new char[sb.length()];
		int index = sb.length();
		for (int i = sb.length()-1; i >= 0; --i) {
			if (set.contains(sb.charAt(i))) continue;
			set.add(sb.charAt(i));
			array[--index] = sb.charAt(i);
		}
		return String.format("%d %s", sb.length(), String.valueOf(array, index, array.length-index));
	}
}