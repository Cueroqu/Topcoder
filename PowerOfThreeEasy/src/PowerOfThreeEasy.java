public class PowerOfThreeEasy {
	public String ableToGet(int x, int y) {
		boolean[] xb = Int2Trinary(x);
		boolean[] yb = Int2Trinary(y);
		int i, minLen = Math.min(xb.length, yb.length), maxLen = xb.length+yb.length-minLen;
		boolean[] longer = (minLen == xb.length) ? yb : xb;
		for (i = 0; i < minLen; ++i) {
			if ((xb[i] && yb[i]) || (!xb[i] && !yb[i])) return "Impossible";
		}
		for (i = minLen; i < maxLen; ++i) {
			if (!longer[i]) return "Impossible";
		}
		return "Possible";
	}
	
	public boolean[] Int2Trinary(int k) {
		if (k == 0) {
			boolean[] ret = new boolean[0];
			return ret;
		}
		boolean[] ret = new boolean[(int)(Math.log(k)/Math.log(3)) + 1];
		int idx = 0;
		while (k > 0) {
			if (k % 3 == 1) ret[idx] = true;
			++idx;
			k /= 3;
		}
		return ret;
	}
}