public class FryingHamburgers {
	public int howLong(int panSize, int hamburgers) {
		return (int)Math.ceil((double)hamburgers*2.0/(double)panSize)*5;
	}
}