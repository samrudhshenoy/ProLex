import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	
	public static final String lineSep = System.getProperty("line.separator");
	public static final String fileSep = System.getProperty("file.separator");
	public static final String valueSep = " - ";
	/**0->offensive (general category, most common)
	 * 1->racial (race)
	 * 2->vulgar (sexual)
	 */
	public static final String[] messages = {"This word has offensive connotations. Are you sure you want to use this word? Here is a replacement suggestion: ",
			"This word can be interpreted as a racial slur. Are you sure you want to use this word? Here is a replacement suggestion: ",
			"This word has vulgar connotations. Are you sure you want to use this word? Here is a replacement suggestion: ",
			"This word has derogatory connotations towards the homosexual community. Are you sure you want to use this word? Here is a replacement word: "};
	
	/**Returns the lines of the file in an ArrayList
	 * 
	 * @param fileName - the file to read
	 * @return 
	 */
	public static ArrayList<String> readFile(String fileName) {
		BufferedReader reader = null;
		try {
			ArrayList<String> lines = new ArrayList<String>();
			reader = new BufferedReader(new FileReader(fileName));
			String in = null;
			while((in = reader.readLine()) != null) {
				lines.add(in);
			}
			return lines;
		}catch(IOException e) {
			System.out.println("IOException");
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(NullPointerException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**Takes in an arraylist of strings. For each string, will see if it's a valid input and then will parse if it is.
	 * If the message is custom, this method will take off the '#' at the beginning and return just the message.
	 * 
	 * @param input
	 * @return
	 */
	public static ArrayList<BadWord> readBadWords(ArrayList<String> input){
		ArrayList<BadWord> badWords = new ArrayList<BadWord>();
		while(!input.isEmpty()) {
			String line = input.remove(0);
			if(line=="\n") {
				continue;
			}else if(!line.contains(" - ")){
				continue;
			}else {
				String badWord = line.substring(0, line.indexOf(" - "));
				line = line.substring(line.indexOf(" - ")+3);
				String replacement = line.substring(0, line.indexOf(" - "));
				line = line.substring(line.indexOf(" - ")+3);
				if(line.charAt(0) == '#') {
					line = line.substring(1);
				}
				badWords.add(new BadWord(badWord,replacement,line));
			}
		}
		return badWords;
	}
	
	
	public static String getMessage(int index, String input) {
		
		return null;
	}
	
	/**dont debug this
	 * 
	 * @param input
	 * @return
	 */
	public static ArrayList<BadWord> parseForBadWords(String input) {
		ArrayList<BadWord> badWords = new ArrayList<BadWord>();
		for(int i = 0; i < ProLexMain.badWords.size(); i++) {
			int index = -1;
			while(input.indexOf(ProLexMain.badWords.get(i).getBadWord(), index + 1) != -1) {
				badWords.add(new BadWord(ProLexMain.badWords.get(i),input.indexOf(ProLexMain.badWords.get(i).getBadWord())));
				index = input.indexOf(ProLexMain.badWords.get(i).getBadWord());
			}
		}
		return badWords;
	}
	
	/** 	
	 * 
	 * @param index
	 * @return
	 */
	public static String getReplacedWord(int index) {
		return null;
	}
}