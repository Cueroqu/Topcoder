public class SplitIntoPairs {
	public int makepairs(int[] A, int X) {
		int minPos = Integer.MAX_VALUE, maxNeg = Integer.MIN_VALUE, posNum = 0, negNum = 0;
		for (int i = 0; i < A.length; ++i) {
			if (A[i] >= 0) {
				++posNum;
				if (minPos > A[i]) minPos = A[i];
			}
			else {
				++negNum;
				if (maxNeg < A[i]) maxNeg = A[i];
			}
		}
		if (posNum % 2 == 0) return posNum/2+negNum/2;
		else {
			int extra = (X / maxNeg >= minPos) ? 1 : 0;
			return posNum/2+negNum/2+extra;
		}
	}
}