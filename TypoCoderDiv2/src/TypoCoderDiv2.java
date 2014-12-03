public class TypoCoderDiv2 {
	public int count(int[] rating) {
		int mark = 500, ret = 0;
		boolean brown = false;
		for (int i = 0; i < rating.length; ++i) {
			mark = rating[i];
			if (brown && mark < 1200 ||
				!brown && mark >= 1200) ++ret;
			brown = mark >= 1200;
		}
		return ret;
	}
}