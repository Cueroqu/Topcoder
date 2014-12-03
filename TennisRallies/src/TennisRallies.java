import java.util.*;
public class TennisRallies {
	class WrapInt {
		int ans = 0;
	}
	public int howMany(int numLength, String[] forbidden, int allowed) {
		char[] ways = new char[numLength];
		Arrays.fill(ways, 'c');
		WrapInt ans = new WrapInt();
		dfs(ways, 0, ans, forbidden, allowed);
		return ans.ans;
	}
	
	public void dfs(char[] ways, int index, WrapInt ans, String[] forbidden, int allowed) {
		if (index == ways.length) {
			if (Valid(ways, forbidden, allowed)) {
				++ans.ans;
			}
			return;
		}
		dfs(ways, index+1, ans, forbidden, allowed);
		ways[index] = 'd';
		dfs(ways, index+1, ans, forbidden, allowed);
		ways[index] = 'c';
	}
	
	public boolean Valid(char[] ways, String[] forbidden, int allowed) {
		int cnt = 0, i, j, k;
		for (i = 0; i < forbidden.length; ++i) {
			for (j = 0; j <= ways.length - forbidden[i].length(); ++j) {
				for (k = j; k < j+forbidden[i].length(); ++k) {
					if (forbidden[i].charAt(k-j) != ways[k]) break;
				}
				if (k == j+forbidden[i].length()) ++cnt;
			}
		}
		return cnt<allowed;
	}
}