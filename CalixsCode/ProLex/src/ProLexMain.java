import java.util.ArrayList;


public class ProLexMain {
	public static ArrayList<BadWord> badWords;

	public static void main(String[] args) {
		ArrayList<String> strings = FileIO.readFile("C:\\Users\\Calix\\Desktop\\abc.txt");
		for (String s : strings) {
			System.out.print(s);
		}
	}
}
