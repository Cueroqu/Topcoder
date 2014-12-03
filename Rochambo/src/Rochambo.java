public class Rochambo {
	public int winOppo(int oppo) {
		switch (oppo) {
			case 'S':
				return 'R';
			case 'P':
				return 'S';
			case 'R':
				return 'P';
		}
		return 'R';
	}
	
	public boolean winOppo(int mine, int oppo) {
		if ((mine == 'R' && oppo == 'S') ||
			(mine == 'S' && oppo == 'P') ||
			(mine == 'P' && oppo == 'R')) return true;
		return false;
	}
	
	public int wins(String opponent) {
		int ret = 0, total = 'S' + 'P' + 'R', mine, fakeoppo;
		if (opponent.charAt(0) == 'S') ++ret;
		if (opponent.charAt(1) == 'S') ++ret;
		for (int i = 2; i < opponent.length(); ++i) {
			if (opponent.charAt(i-2) == opponent.charAt(i-1)) fakeoppo = opponent.charAt(i-1);
			else fakeoppo = total - opponent.charAt(i-2)-opponent.charAt(i-1);
			mine = winOppo(fakeoppo);
			if (winOppo(mine, opponent.charAt(i))) ++ret;
		}
		return ret;
	}
}