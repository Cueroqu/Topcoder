import java.util.*;
public class IsHomomorphism {
	public String[] numBad(String[] source, String[] target, int[] mapping) {
		List<String> retList = new ArrayList<String>();
		int i, j;
		for (i = 0; i < mapping.length; ++i) {
			for (j = 0; j < mapping.length; ++j) {
				if (mapping[source[i].charAt(j) - '0'] != 
					target[mapping[i]].charAt(mapping[j]) - '0') retList.add(String.format("(%d,%d)", i, j));
			}
		}
		String[] ret = new String[retList.size()];
		return retList.toArray(ret);
	}
}