public class WinterAndMandarins {
	public int getNumber(int[] bags, int K) {
		sort(bags);
		int ret = bags[K-1] - bags[0];
		for (int i = 1; i < bags.length - K ; ++i) {
			ret = Math.min(bags[i+K-1] - bags[i], ret);
		}
		return ret;
	}
	
	public void sort(int[] bags) {
		int[] tmp = new int[bags.length];
		int i, j, srcIdx, tmpIdx;
		for (i = 0; i < 32; ++i) {
			srcIdx = tmpIdx = 0;
			for (j = 0; j < bags.length; ++j) {
				boolean move = (((bags[j] >> i) & 1) == 1);
				if (i == 31) move = !move;
				if (move) {
					tmp[tmpIdx++] = bags[j];
				} else {
					bags[srcIdx++] = bags[j];
				}
			}
			System.arraycopy(tmp, 0, bags, srcIdx, tmpIdx);
		}
	}
}