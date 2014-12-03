public class ThePriceIsRight {
	class LengthAndCnt {
		int length = 1;
		int cnt = 1;
	}
	public int[] howManyReveals(int[] prices) {
		if (prices.length == 0) return new int []{0, 0};
		LengthAndCnt[] lac = new LengthAndCnt[prices.length];
		lac[0] = new LengthAndCnt();
		int[] ret = new int[2];
		ret[0] = ret[1] = 1;
		int i, j;
		for (i = 1; i < prices.length; ++i) {
			lac[i] = new LengthAndCnt();
			for (j = 0; j < i; ++j) {
				if (prices[j] < prices[i]) {
					if (lac[i].length < lac[j].length+1) {
						lac[i].length = lac[j].length+1;
						lac[i].cnt = lac[j].cnt;
					} else if (lac[i].length == lac[j].length+1) {
						lac[i].cnt += lac[j].cnt;
					}
				}
			}
			if (ret[0] < lac[i].length) {
				ret[0] = lac[i].length;
				ret[1] = lac[i].cnt;
			} else if (ret[0] == lac[i].length) {
				ret[1] += lac[i].cnt;
			}
		}
		return ret;
	}
}