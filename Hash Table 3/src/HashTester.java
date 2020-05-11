import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTester {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> Input = new ArrayList<String>();
		ArrayList<String> SSearch = new ArrayList<String>();
		ArrayList<String> USSearch = new ArrayList<String>();
		double[] alpha = {.1, .5, .8, .9, 1.0};
		HashTable Table;
		Scanner SC = new Scanner(new File("Large Data Set.txt"));
		while (SC.hasNext())
			Input.add(SC.nextLine());
		SC = new Scanner(new File("Successful Search.txt"));
		while (SC.hasNext())
			SSearch.add(SC.nextLine());
		SC = new Scanner(new File("Unsuccessful Search.txt"));
		while (SC.hasNext())
			USSearch.add(SC.nextLine());
		SC.close();
		
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] == .1) {
				Table = new HashTable(5000011);
			}else if(alpha[i] == .5) {
				Table = new HashTable(1000003);
			}else if(alpha[i] == .8) {
				Table = new HashTable(625169);
			}else if(alpha[i] == .9) {
				Table = new HashTable(555557);
			}else {
				Table = new HashTable(500009);
			}
			
			long IStart = System.currentTimeMillis();
			for (String S : Input) {
				Table.put(Integer.parseInt(S.substring(0, 8).trim()), S.substring(9).trim());
			}
			long IStop = System.currentTimeMillis();
			int PutCol = Table.PCollisions;
			Table.PCollisions = 0;
			
			long SSStart = System.currentTimeMillis();
			for (String S : SSearch) {
				Table.get(Integer.parseInt(S.substring(0, 8).trim()));
			}
			long SSStop = System.currentTimeMillis();
			int SGetCol = Table.GCollisions;
			Table.GCollisions = 0;
			
			long USStart = System.currentTimeMillis();
			for (String S : USSearch) {
				Table.get(Integer.parseInt(S.substring(0, 8).trim()));
			}
			long USStop = System.currentTimeMillis();
			int USGetCol = Table.GCollisions;
			Table.GCollisions = 0;
			
			System.out.println(
					"Type of hashing used: Linear Probing\n" +
					"Hash Function used: Integer Value\n" +
					"Number of elements added: 500000\n" +
					"Table Size: " + Table.MaxLength + "\n" +
					"Load Factor: ~" + alpha[i] + "\n" +
					"Total insersion time: " + (double)(((IStop - IStart))) + "ms\n" +
					"Average Collisions on insert: " + (PutCol / 500000) + "\n" +
					"Collisions vs insertions: " + (double)((PutCol / 500000) * 100) + "%\n" +
					"Total time to Find and Average probes: " + ((double)(((SSStop - SSStart)))) + "ms, " + (SGetCol / 100000) + "\n" +
					"Total time to eliminate and Average probes: " + ((double)(((USStop - USStart)))) + "ms, " + (USGetCol / 100000) + "\n\n\n\n"
					);
		}
	}
}
