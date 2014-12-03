public class DiskSpace {
	public void sort(int[] total) {
		int[] tmp = new int[total.length];
		int tmpsize, originsize;
		boolean move;
		for (int i = 0; i < 32; ++i) {
			tmpsize = originsize = 0;
			for (int j = 0; j < total.length; ++j) {
				move = ((total[j] >> i) & 1) == 1 ? true : false;
				if (move && i != 31) tmp[tmpsize++] = total[j];
				else total[originsize++] = total[j];
			}
			System.arraycopy(tmp, 0, total, originsize, tmpsize);
		}
	}
	public int minDrives(int[] used, int[] total) {
		sort(total);
		int sum = 0, i;
		for (i = 0; i < used.length; ++i) sum += used[i];
		for (i = total.length - 1; i >= 0 && sum > 0; --i) sum -= total[i];
		return total.length - i - 1;
	}
	
	// below is the code for method 2
	
	class PivotAndSumPair {
		int pivot;
		int sum;
		public PivotAndSumPair(int p, int s) {
			pivot = p;
			sum = s;
		}
	}
	
	public PivotAndSumPair partition(int[] total, int start, int end) {
		int s = total[start], m = end+1, t, sum = 0;
		for (int j = end; j >= start; --j) {
			if (total[j] >= s) {
				sum += total[j];
				t = total[j];
				total[j] = total[--m];
				total[m] = t;
			}
		}
		sum -= s;
		return new PivotAndSumPair(m, sum);
	}
	
	// also theta(n), but smaller coefficient
	public int minDrives2(int[] used, int[] total) {
		int sum = 0, i, start = 0, end = total.length-1;
		PivotAndSumPair psp;
		for (i = 0; i < used.length; ++i) sum += used[i];
		for (;;) {
			psp = partition(total, start, end);
			if (psp.sum == sum) return total.length-1-psp.pivot;
			if (psp.sum > sum) start = psp.pivot+1;
			else {
				psp.sum += total[psp.pivot];
				if (psp.sum >= sum) return total.length - psp.pivot;
				sum -= psp.sum;
				end = psp.pivot-1;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}