public class Inchworm {
	int gcd(int a, int b) {
		int t;
		while (b > 0) {
			t = b;
			b = a%b;
			a = t;
		}
		return a;
	}
	public int lunchtime(int branch, int rest, int leaf) {
		int lcm = rest * leaf / gcd(rest, leaf);
		return branch / lcm + 1;
	}
}