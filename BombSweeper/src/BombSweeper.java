public class BombSweeper {
	public double winPercentage(String[] board) {
		if (board.length == 0) return 0;
		double winCnt = 0, loseCnt = 0;
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length(); ++j) {
				if (board[i].charAt(j) == 'B') {
					++loseCnt;
				} else if (Test(board, i, j)) ++winCnt;
			}
		}
		return winCnt * 100.0 / (loseCnt+winCnt);
	}
	
	int[] diri = new int[]{-1,0,1,-1,0,1,-1,0,1};
	int[] dirj = new int[]{-1,-1,-1,0,0,0,1,1,1};
	
	public boolean Test(String[] board, int row, int col) {
		int r, c;
		for (int i = 0; i < diri.length; ++i) {
			r = row + diri[i];
			c = col + dirj[i];
			if (r < 0 || c < 0 || r >= board.length || c >= board[0].length()) continue;
			if (board[r].charAt(c) == 'B') return false;
		}
		return true;
	}
}