public class TheShuttles {
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		int i, j;
		int minValue = Integer.MAX_VALUE, sum, carnum, carcost;
		for (i = 1; i <= 100; ++i) {
			sum = 0;
			carcost = baseCost + seatCost * i;
			for (j = 0; j < cnt.length; ++j) {
				carnum = (int)Math.ceil((double)cnt[j] / (double)i);
				sum += carcost * carnum;
			}
			if (sum < minValue) minValue = sum;
		}
		return minValue;
	}
}