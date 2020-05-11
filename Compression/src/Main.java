import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static final String Input_Path = "Input/";
	public static final String Hold_Path = "Hold/";
	public static final String Output_Path = "OutPut/";
	
	public static final String[] Files = {
			"A Tale of Two Cities",
			"Aesop's Fables",
			"Amendments to the Constitution",
			"Anna Karenina - Diff",
			"Anna Karenina",
			"Communist Manifesto",
			"dream",
			"Little Women",
			"Magna Carta",
			"Moby Dick",
			"Much Ado About Nothing",
			"The Three Musketeers",
			"Tom Sawyer",
			"Treasure Island",
			"War and Peace"
	};
	
	public static void main(String[] args) throws Exception {
		for (String File_N : Files) {
			File IN = new File(Input_Path + File_N + ".txt");
			Scanner SC = new Scanner(IN);
			String Check = Read(SC);
			
			
			HuffmanCore Comp = new HuffmanCore(Check, File_N);
			System.out.println("File_In: " + File_N + ".txt\nFlile_Out: " + File_N + ".mhout\n\n");
		}
	}
	
	public static String Read(Scanner SC) {
		StringBuilder Build = new StringBuilder();

		while(SC.hasNextLine())
		{
			String s = SC.nextLine();
			Build.append(s);
			Build.append('\n');
		}
		
		return Build.toString();
	}

}
