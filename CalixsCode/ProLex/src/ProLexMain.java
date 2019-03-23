import java.util.ArrayList;


public class ProLexMain {
	public static ArrayList<BadWord> badWords;

	public static void main(String[] args) {
		ArrayList<String> strings = FileIO.readFile("data\\def.txt");
		badWords = FileIO.readBadWords(strings);
		for(BadWord b : badWords) {
			System.out.println(b);
		}
	}
}
