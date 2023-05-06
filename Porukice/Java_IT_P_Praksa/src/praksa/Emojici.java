package praksa;

public enum Emojici {

	HAPPY("(😄|🙂|😊|😍)"), SAD("(😢|😭|😞|👿)"), LOVING("(😍|😘)");

	private String emoji;

	private Emojici(String emoji) {
		this.emoji = emoji;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}

}