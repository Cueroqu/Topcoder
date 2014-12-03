import java.util.*;
public class UserId {
	public String simplify(String s) {
		return s.toLowerCase().replaceAll("[ ']", "");
	}

	public String id(String[] inUse, String first, String middle, String last) {
		if (inValid(first, false) || inValid(middle, true) || inValid(last, false)) return "BAD DATA";
		Set<String> set = new HashSet<String>();
		for (String s : inUse)
			set.add(s.toLowerCase());
		first = simplify(first);
		middle = simplify(middle);
		last = simplify(last);
		String candidate = first.charAt(0) + last;
		if (candidate.length() > 8)
			candidate = candidate.substring(0, 8);
		String candidate2;
		if (!set.contains(candidate)) return candidate;
		if (middle.length() > 0) {
			candidate2 = "" + first.charAt(0) + "" + middle.charAt(0) + last;
			if (candidate2.length() > 8)
				candidate2 = candidate2.substring(0, 8);
			if (!set.contains(candidate2)) return candidate2;
		}
		if (candidate.length() > 6)
			candidate = candidate.substring(0, 6);
		for (int i = 1; i < 100; ++i) {
			candidate2 = String.format("%s%02d", candidate, i);
			if (!set.contains(candidate2)) return candidate2;
		}
		return "";
	}
	
	public boolean inValid(String name, boolean isMiddle) {
		if (!isMiddle && name.length() <= 2) return true;
		char c;
		for (int i = 0; i < name.length(); ++i) {
			c = name.charAt(i);
			if (!Character.isLetter(c) && c != '\'' && c != ' ') return true;
		}
		return false;
	}
}