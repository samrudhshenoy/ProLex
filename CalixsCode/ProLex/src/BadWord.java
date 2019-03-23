
public class BadWord {
	private String badWord;
	private String replacement;
	private String message;
	
	public BadWord(String badWord, String replacement, String message) {
		this.badWord = badWord;
		this.replacement = replacement;
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
}
