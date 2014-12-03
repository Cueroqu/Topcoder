public class CardCount {
	public String[] dealHands(int numPlayers, String deck) {
		StringBuilder[] sbs = new StringBuilder[numPlayers];
		for (int i = 0; i < numPlayers; ++i) sbs[i] = new StringBuilder();
		int cardNum = deck.length() / numPlayers, total = cardNum * numPlayers;
		for (int i = 0; i < total; ++i) {
			sbs[i%numPlayers].append(deck.charAt(i));
		}
		String[] ret = new String[numPlayers];
		for (int i = 0; i < numPlayers; ++i) ret[i] = sbs[i].toString();
		return ret;
	}
}