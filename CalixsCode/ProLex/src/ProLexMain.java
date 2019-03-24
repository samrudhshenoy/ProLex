import java.util.ArrayList;
import java.util.Scanner;


public class ProLexMain {
	public static ArrayList<BadWord> badWords;

	public static void main(String[] args) {
		//initialize the badWords arraylist - now we can actually check for bad words.
		ArrayList<String> strings = FileIO.readFile("data" + FileIO.fileSep + "def.txt");
		badWords = FileIO.readBadWords(strings);
		
		//
		Scanner in = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("Input a string to scan:");
			String s = in.nextLine();
			if(s.equals("exit")) {
				System.out.println("Thanks for using ProLex! GoodBye.");
				loop = false;
			}else {
				ArrayList<BadWord> foundWords = FileIO.parseForBadWords(s);
				for(BadWord b : foundWords) {
					System.out.println(b.locateInString());
				}
				if(foundWords.isEmpty()) {
					System.out.println("No bad words found!");
				}
			}
		}
	}
}
