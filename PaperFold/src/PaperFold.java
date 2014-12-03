public class PaperFold {
	public int numFolds(int[] paper, int[] box) {
		int cnt = numFoldsSolve(paper[0], paper[1], box[0], box[1], 0);
		if (cnt > 8) return -1;
		return cnt;
	}
	
	int numFoldsSolve(double pw, double pl, double bw, double bl, int depth) {
		if (depth > 8) return 9;
		if ((pw <= bw && pl <= bl) ||
			(pl <= bw && pw <= bl)) return depth;
		return Math.min(numFoldsSolve(pw/2., pl, bw, bl, depth+1), numFoldsSolve(pw, pl/2., bw, bl, depth+1));
	}
}