public class PilingRectsDiv2 {
	public int getmax(int[] X, int[] Y, int limit) {
		int ans = -1, i, j, k, tmp;
		for (i = 1; i <= 200; ++i) {
			for (j = 1; j <= 200; ++j) {
				if (i*j < limit) continue;
				tmp = 0;
				for (k = 0; k < X.length; ++k) {
					if (X[k] >= i && Y[k] >= j ||
						X[k] >= j && Y[k] >= i) {
						++tmp;
					}
				}
				if (tmp > 0) ans = Math.max(ans, tmp);
			}
		}
		return ans;
	}
}