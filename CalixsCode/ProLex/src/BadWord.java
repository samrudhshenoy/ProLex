
public class BadWord {
	private String badWord;
	private String replacement;
	private String message;
	private int index;
	
	public BadWord(String badWord, String replacement, String message) {
		this.badWord = badWord;
		this.replacement = replacement;
		this.index = -1;
		try {
			int n = Integer.parseInt(message);
			if(n<0 || n>FileIO.messages.length - 1) {
				throw new IllegalArgumentException("message number is invalid for badword.");
			}else {
				this.message = FileIO.messages[n];
			}
		}catch(NumberFormatException e) {
			this.message = message;
		}
	}
	public BadWord(String badWord, String replacement, String message, int index) {
		this.badWord = badWord;
		this.replacement = replacement;
		this.index = index;
		try {
			int n = Integer.parseInt(message);
			if(n<0 || n>FileIO.messages.length - 1) {
				throw new IllegalArgumentException("message number is invalid for badword.");
			}else {
				this.message = FileIO.messages[n];
			}
		}catch(NumberFormatException e) {
			this.message = message;
		}
	}
	public BadWord(BadWord b, int index) {
		this.badWord = b.getBadWord();
		this.replacement = b.getReplacement();
		this.message = b.getMessage();
		this.index = index;
	}
	public String getBadWord() {
		return badWord;
	}
	public String getReplacement() {
		return replacement;
	}
	public String getMessage() {
		return message;
	}
	public String toString() {
		return "bad word: " + badWord + FileIO.lineSep + "replacement: " + replacement + FileIO.lineSep +  "message: " + message + FileIO.lineSep;
	}
	public String locateInString() {
		return badWord + " found at index " + index;
	}
}
