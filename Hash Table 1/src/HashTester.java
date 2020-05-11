import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTester {
	public static void main(String[] args) throws FileNotFoundException {
		HashTable HT = new HashTable();
		Scanner SC = new Scanner(new File("data.txt"));
		while (SC.hasNext()) {
			String temp = SC.nextLine();
			HT.put(Integer.parseInt(temp.substring(0, 8)), temp.substring(9));
		}
		System.out.println(HT.toString());
	}
}
