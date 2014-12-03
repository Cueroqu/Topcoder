public class ORSolitaireDiv2 {
	public int getMinimum(int[] numbers, int goal) {
		boolean[] goalArray = Int2BooleanArray(goal);
		int[] sameCnt = new int[32];
		int i, j;
		for (i = 0; i < numbers.length; ++i) {
			boolean[] tmpArray = Int2BooleanArray(numbers[i]);
			if (impossible(tmpArray, goalArray)) continue;
			for (j = 0; j < tmpArray.length; ++j) {
				if (tmpArray[j] == goalArray[j]) ++sameCnt[j];
			}
		}
		int ret = numbers.length;
		for (i = 0; i < sameCnt.length; ++i) {
			if (goalArray[i] && sameCnt[i] < ret) {
				ret = sameCnt[i];
			}
		}
		return ret;
	}
	
	public boolean impossible(boolean[] subset, boolean[] src) {
		for (int i = 0; i < src.length; ++i) {
			if (!src[i] && subset[i]) return true;
		}
		return false;
	}
	
	public boolean[] Int2BooleanArray(int goal) {
		boolean[] ret = new boolean[32];
		for (int i = 0; i < 32 && goal > 0; ++i, goal >>= 1) {
			ret[i] = ((goal & 1) == 1);
		}
		return ret;
	}
}