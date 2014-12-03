public class WinterAndCandies {
	class WrapInt {
		int ans = 0;
	}
	public int getNumber(int[] type) {
		WrapInt ans = new WrapInt();
		boolean[] record = new boolean[type.length];
		dfs(type, 0, record, 0, ans);
		return ans.ans;
	}
	
	public void dfs(int[] type, int index, boolean[] record, int cnt, WrapInt ans) {
		if (index == type.length) return;
		
		dfs(type, index+1, record, cnt, ans);
		if ((type[index] <= type.length) && !record[type[index]-1]) {
			record[type[index]-1] = true;
			int i;
			for (i = 0; i <= cnt; ++i) {
				if (!record[i]) break;
			}
			if (i == cnt+1) {
				++ans.ans;
			}
			
			dfs(type, index+1, record, cnt+1, ans);
			record[type[index]-1] = false;
		}
	}
}