public class CalendarRecycle {
	public int useAgain(int year) {
		int tail = 1, i;
		boolean leapYear = isLeapYear(year), tmp;
		if (leapYear) ++tail;
		for (i = year+1;; ++i) {
			tmp = isLeapYear(i);
			if (tmp == leapYear && tail % 7 == 0) return i;
			if (tmp) tail += 2;
			else ++tail;
		}
	}
	
	public boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			return year % 400 == 0;
		} else return year % 4 == 0;
	}
}