public class Pool {
	public void simplify(int[] triangle) {
		for (int i = 0; i < triangle.length; ++i) {
			if (triangle[i] < 8) triangle[i] = 0;
			else if (triangle[i] > 8) triangle[i] = 1;
		}
	}
	
	public int distance(int[][] standards, int[] triangle) {
		int dis0 = 0, dis1 = 0;
		for (int i = 0; i < triangle.length; ++i) {
			if (triangle[i] != standards[0][i]) ++dis0;
			if (triangle[i] != standards[1][i]) ++dis1;
		}
		return Math.min(dis0, dis1);
	}
	
	public int rackMoves(int[] triangle) {
		int[][] standards = new int[2][];
		standards[0] = new int[]{1,0,0,1,8,1,0,1,0,1,1,0,1,0,0};
		standards[1] = new int[]{0,1,1,0,8,0,1,0,1,0,0,1,0,1,1};
		simplify(triangle);
		int dis = distance(standards, triangle);
		int ret = dis/2;
		if (dis%2==1) ++ret;
		return ret;
	}
}