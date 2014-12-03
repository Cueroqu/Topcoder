public class Salary {
	double[] base = new double[]{1., 60., 3600.};

	public int howMuch(String[] arrival, String[] departure, int wage) {
		double income = 0;
		String split = "18:00:00", split2 = "06:00:00";
		for (int i = 0; i < arrival.length; ++i) {
			if (LaterThan18(arrival[i]) || EarlierThan6(departure[i])) {
				income += GetSalary(GetTimeDifference(arrival[i], departure[i]), 1.5 * wage);
			} else if (EarlierThan6(arrival[i]) && LaterThan18(departure[i])) {
				income += GetSalary(GetTimeDifference(arrival[i], split2), 1.5 * wage);
				income += GetSalary(GetTimeDifference(split2, split), wage);
				income += GetSalary(GetTimeDifference(split, departure[i]), 1.5 * wage);
			} else if (LaterThan18(departure[i])) {
				income += GetSalary(GetTimeDifference(arrival[i], split), wage);
				income += GetSalary(GetTimeDifference(split, departure[i]), 1.5 * wage);
			} else if (EarlierThan6(arrival[i])) {
				income += GetSalary(GetTimeDifference(arrival[i], split2), 1.5 * wage);
				income += GetSalary(GetTimeDifference(split2, departure[i]), wage);
			}			
			else {
				income += GetSalary(GetTimeDifference(arrival[i], departure[i]), wage);
			}
		}
		return (int)income;
	}
	
	public double GetSalary(TimeDifference td, double wage) {
		double ret = 0;
		for (int i = 0; i < 3; ++i) ret += td.vals[i] * wage / base[i];
		return ret;
	}
	
	public boolean LaterThan18(String s) {
		return s.charAt(0) == '2' || (s.charAt(0) == '1' && s.charAt(1) >= '8');
	}
	
	public boolean EarlierThan6(String s) {
		return s.charAt(0) == '0' && s.charAt(1) < '6';
	}
	
	public TimeDifference GetTimeDifference(String arrival, String depart) {
		String[] arrtmp = arrival.split(":");
		String[] deptmp = depart.split(":");
		double[] arrtime = new double[3];
		double[] deptime = new double[3];
		for (int i = 0; i < 3; ++i) {
			arrtime[i] = Double.parseDouble(arrtmp[i]);
			deptime[i] = Double.parseDouble(deptmp[i]);
		}
		for (int i = 2; i > 0; --i) {
			if (deptime[i] < arrtime[i]) {
				deptime[i] += 60;
				--deptime[i-1];
			}
		}
		return new TimeDifference(deptime, arrtime);
	}
	
	class TimeDifference {
		double[] vals;	//0: hour, 1: min, 2: sec;
		public TimeDifference(double[] deptime, double[] arrtime) {
			vals = new double[3];
			for (int i = 0; i < 3; ++i) vals[i] = deptime[i] - arrtime[i];
		}
	}
}