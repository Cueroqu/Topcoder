public class LCMRange {
	public int gcd(int a, int b) {
		int t;
		while (b != 0) {
			t = b;
			b = a%b;
			a = t;
		}
		return a;
	}
	public int lcm(int first, int last) {
		int ret = last, tgcd;
		for (int i = last - 1; i >= first; --i) {
			tgcd = gcd(ret, i);
			ret = ret * i / tgcd;
		}
		return ret;
	}
}