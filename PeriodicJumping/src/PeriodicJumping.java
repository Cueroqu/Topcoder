public class PeriodicJumping {
	public int minimalTime(int x, int[] jumpLengths) {
		if (x == 0) return 0;
		long dis = Math.abs(x), sum = 0;
		int cnt = 0;
		
		for (int i = 0; i < jumpLengths.length; ++i) {
			sum += jumpLengths[i];
		}
		long loops = Math.max(0, dis / sum - 2), m = 0;
		sum *= loops;
		cnt = (int)loops * jumpLengths.length;
				
		for (int i = 0; ; ++i) {
			// the three edges can compose a triangle
			// one of the length is "dis", for the other two, one is at least of length "m"
			// thus the other should be sum-m, i.e, (sum-m), m, and dis compose a triangle
			if (sum >= dis && m <= (dis+sum-m)) {
				break;
			}
			++cnt;
			int j = jumpLengths[i%jumpLengths.length];
			sum += j;
			m = Math.max(m, j);
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		PeriodicJumping pj = new PeriodicJumping();
		pj.minimalTime(-1000000000, new int[]{1});
	}
}