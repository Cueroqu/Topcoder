import java.util.*;
public class Quilting {
	int[] dirr = new int[]{-1, 0, 1, 0};
	int[] dirc = new int[]{0, -1, 0, 1};
	int[] neir = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
	int[] neic = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
	
	class Direction {
		int rowDir;
		int colDir;
		int length;
		int direction;
		int width;
		public Direction(int l, int w) {
			length = l;
			width = w;
			rowDir = length / 2;
			colDir = width / 2;
			direction = 1;
		}
		public void update(int[][] colorIndex) {
			int nextd = (direction+1)%4;
			int tmpr = rowDir + dirr[nextd], tmpc = colDir + dirc[nextd];
			if (colorIndex[tmpr][tmpc] == -1) {
				direction = nextd;
				rowDir = tmpr;
				colDir = tmpc;
				return;
			}
			tmpr = rowDir + dirr[direction];
			tmpc = colDir + dirc[direction];
			if (inBound(tmpr, tmpc)) {
				rowDir = tmpr;
				colDir = tmpc;
				return;
			}
			direction = nextd;
			while (colorIndex[rowDir][colDir] >= 0) {
				rowDir += dirr[direction];
				colDir += dirc[direction];
			}
		}
		public boolean inBound(int row, int col) {
			if (row < 0 || row >= length) return false;
			if (col < 0 || col >= width) return false;
			return true;
		}
	}
	
	public int SelectColor(int[][] colorIndex, Direction d, int[] colorCnt) {
		int[] cnt = new int[colorCnt.length];
		int tmpr, tmpc;
		for (int i = 0; i < 8; ++i) {
			tmpr = d.rowDir + neir[i];
			tmpc = d.colDir + neic[i];
			if (d.inBound(tmpr, tmpc) && colorIndex[tmpr][tmpc] != -1) {
				cnt[colorIndex[tmpr][tmpc]]++;				
			}
		}
		int recordCnt = 0, minNum = 8;
		for (int i = 0; i < cnt.length; ++i) {
			if (cnt[i] < minNum) {
				minNum = cnt[i];
				recordCnt = 0;
				cnt[recordCnt++] = i;
			} else if (cnt[i] == minNum) {
				cnt[recordCnt++] = i;
			}
		}
		if (recordCnt == 1) return cnt[0];
		boolean valid = true;
		minNum = colorCnt[cnt[0]];
		int leastUsedIndex = 0;
		int minIndex = 0;
		for (int i = 1; i < recordCnt; ++i) {
			if (minNum > colorCnt[cnt[i]]) {
				minNum = colorCnt[cnt[i]];
				valid = true;
				leastUsedIndex = i;
			} else if (minNum == colorCnt[cnt[i]]) valid = false;
			if (cnt[i] < cnt[minIndex]) minIndex = i;
		}
		if (valid) return cnt[leastUsedIndex];
		else return cnt[minIndex];
	}
	
	public String lastPatch(int length, int width, String[] colorList) {
		if (length == 1) return colorList[0];
		if (length == 2 && width == 1) return colorList.length > 1 ? colorList[1] : colorList[0];
		int[][] colorIndex = new int[length][width];
		int[] colorCnt = new int[colorList.length];
		for (int[] array : colorIndex) Arrays.fill(array, -1);
		Direction d = new Direction(length, width);
		int ci = 0, cnt = 1;
		colorIndex[d.rowDir--][d.colDir] = ci;
		colorCnt[ci]++;
		for (;;) {
			ci = SelectColor(colorIndex, d, colorCnt);
			colorIndex[d.rowDir][d.colDir] = ci;
			++cnt;
			colorCnt[ci]++;
			if (cnt >= length * width) break;
			d.update(colorIndex);
		}
		return colorList[ci];
	}
}