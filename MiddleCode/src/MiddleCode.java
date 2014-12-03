public class MiddleCode {
	public String encode(String s) {
		StringBuilder sb = new StringBuilder(s);
		StringBuilder ret = new StringBuilder();
		int len;
		while (sb.length() > 0) {
			len = sb.length();
			if (len%2==1) {
				ret.append(sb.charAt(len/2));
				sb.deleteCharAt(len/2);
			} else {
				int idx = (sb.charAt(len/2) > sb.charAt(len/2-1)) ? (len/2-1) : len/2;
				ret.append(sb.charAt(idx));
				sb.deleteCharAt(idx);
			}
		}
		return ret.toString();
	}
}