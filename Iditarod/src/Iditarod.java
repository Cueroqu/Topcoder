public class Iditarod {
	double day1total = (24-8)*60;
	double wholeday = 24*60;
	public double[] parseTime(String time) {
		String[] tmp = time.substring(0, 5).split(":", 2);
		double[] ret = new double[2];
		ret[0] = Double.parseDouble(tmp[0]);
		ret[1] = Double.parseDouble(tmp[1]);
		if (ret[0] == 12) ret[0] -= 12;
		if (time.charAt(6) == 'P') ret[0] += 12;
		return ret;
	}
	public double getTime(String time) {
		String[] tmp = time.split(", ", 2);
		int day = Integer.parseInt(tmp[1].substring(4));
		double[] timeInDouble = parseTime(tmp[0]);
		switch (day) {
			case 1:
				return (timeInDouble[0]-8)*60+timeInDouble[1];
			default:
				return day1total + (day-2)*wholeday + timeInDouble[0]*60+timeInDouble[1];
		}
	}
	public int avgMinutes(String[] times) {
		double total = 0;
		for (int i = 0; i < times.length; ++i) {
			total += getTime(times[i]);
		}
		return (int)(total/(double)times.length+0.5);
	}
}