
public class BadWord {
	private String badWord;
	private String replacement;
	private String message;
	
	public BadWord(String badWord, String replacement, String message) {
		this.badWord = badWord;
		this.replacement = replacement;
		try {
			int n = Integer.parseInt(message);
			if(n<0 || n>FileIO.messages.length - 1) {
				throw new IllegalArgumentException("message number is invalid for badword.");
			}else {
				this.message = FileIO.messages[n] + replacement;
			}
		}catch(NumberFormatException e) {
			this.message = message + replacement;
		}
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
}
