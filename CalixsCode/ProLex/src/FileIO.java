import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	
	public static final String lineSep = System.getProperty("line.separator");
	public static final String fileSep = System.getProperty("file.separator");
	/**0->offensive (general category, most common)
	 * 1->racial (race)
	 * 2->vulgar (sexual)
	 */
	public static final String[] messages = {"This word has offensive connotations. Are you sure you want to use this word? Here is a replacement suggestion: ",
			"This word can be interpreted as a racial slur. Are you sure you want to use this word? Here is a replacement suggestion: ",
			"This word has vulgar connotations. Are you sure you want to use this word? Here is a replacement suggestion: "};
	
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
			System.out.println(e.getStackTrace());
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}
		return null;
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
