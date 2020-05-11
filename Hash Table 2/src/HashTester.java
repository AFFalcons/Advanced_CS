import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTester {
	public static void main(String[] args) throws FileNotFoundException {
		HashTable HT = new HashTable();
		Scanner SC = new Scanner(new File("1P.txt"));
		while (SC.hasNext()) {
			String[] temp = SC.nextLine().split(":");
			String Hold = temp[1].trim();
			HT.put(Integer.parseInt(Hold.substring(0, 8)),Hold.substring(9));
		}
		SC = new Scanner(new File("2R.txt"));
		while (SC.hasNext()) {
			String[] temp = SC.nextLine().split(":");
			String Hold = temp[1].trim();
			HT.remove(Integer.parseInt(Hold.substring(0, 8)));
		}
		SC = new Scanner(new File("3PO.txt"));
		while (SC.hasNext()) {
			String[] temp = SC.nextLine().split(":");
			String Hold = temp[1].trim();
			HT.put(Integer.parseInt(Hold.substring(0, 8)),Hold.substring(9));
		}
		SC = new Scanner(new File("4P.txt"));
		while (SC.hasNext()) {
			String[] temp = SC.nextLine().split(":");
			String Hold = temp[1].trim();
			HT.put(Integer.parseInt(Hold.substring(0, 8)),Hold.substring(9));
		}
		System.out.println(HT.toString());
	}
}
