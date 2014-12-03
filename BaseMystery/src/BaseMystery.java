import java.util.regex.*;
public class BaseMystery {
	public int[] getBase(String equation) {
		String pattern = "(.+)?\\+(.+)?=(.+)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(equation);
		if (m.find()) {
			int base = ParseChar(m.group(1).charAt(0)) + 1, i, j;
			for (i = 1; i <= 3; ++i) {
				for (j = 0; j < m.group(i).length(); ++j) {
					if (base < ParseChar(m.group(i).charAt(j))+1) base = ParseChar(m.group(i).charAt(j))+1;
				}
			}
			int ret = 0, cnt = 0;
			for (; base <= 20; ++base) {
				if (Valid(m.group(1), m.group(2), m.group(3), base)) {
					ret |= (1<<base);
					++cnt;
				}
			}
			int[] retArray = new int[cnt];
			cnt = 0;
			ret >>= 2;
			for (i = 2; i <= 20; ++i) {
				if ((ret & 1) == 1) {
					retArray[cnt++] = i;
				}
				ret >>= 1;
			}
			return retArray;
		}
		return null;
	}
	
	public boolean Valid(String add1, String add2, String ans, int base) {
		int addi1 = ParseString(add1, base), addi2 = ParseString(add2, base), ansi = ParseString(ans, base);
		return addi1+addi2 == ansi;
	}
	
	public int ParseString(String s, int base) {
		int ret = 0;
		for (int i = 0; i < s.length(); ++i) {
			ret = ret*base + ParseChar(s.charAt(i));
		}
		return ret;
	}
	
	public int ParseChar(char c) {
		if (c >= '0' && c <= '9') return c-'0';
		return c - 'A' + 10;
	}
}