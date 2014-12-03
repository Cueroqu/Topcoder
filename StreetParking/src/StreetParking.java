public class StreetParking {
	public int freeParks(String street) {
		boolean[] nopark = new boolean[street.length()];
		for (int i = 0; i < street.length(); ++i) {
			if (street.charAt(i) != '-') {
				nopark[i] = true;
				switch (street.charAt(i)) {
					case 'B':
						if (i>=2) nopark[i-2] = nopark[i-1] = true;
						else if (i == 1) nopark[i-1] = true;
						break;
					case 'S':
						if (i >= 1) nopark[i-1] = true;
						if (i < street.length()-1) nopark[i+1] = true;
						break;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < street.length(); ++i) {
			if (!nopark[i]) ++ cnt;
		}
		return cnt;
	}
}