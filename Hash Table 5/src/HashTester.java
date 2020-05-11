import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTester {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Car> Input = new ArrayList<Car>();
		ArrayList<Car> SSearch = new ArrayList<Car>();
		ArrayList<Car> USSearch = new ArrayList<Car>();
		
		double[] alpha = {.1, .5, .8, .9, 1.0};
		
		HashTable Table;
		
		String Hold;
		
		Scanner SC = new Scanner(new File("Large Data Set.txt"));
		while (SC.hasNext()) {
			Hold = SC.nextLine();
			Input.add(new Car(Hold.substring(0, 17).trim(), Hold.substring(18, 22).trim(), Hold.substring(23, 66).trim(), Hold.substring(67).trim()));
		}
		
		SC = new Scanner(new File("Successful Search.txt"));
		while (SC.hasNext()) {
			Hold = SC.nextLine();
			SSearch.add(new Car(Hold.substring(0, 17).trim(), Hold.substring(18, 22).trim(), Hold.substring(23, 66).trim(), Hold.substring(67).trim()));
		}
		
		SC = new Scanner(new File("Unsuccessful Search.txt"));
		while (SC.hasNext()) {
			Hold = SC.nextLine();
			USSearch.add(new Car(Hold.substring(0, 17).trim(), Hold.substring(18, 22).trim(), Hold.substring(23, 66).trim(), Hold.substring(67).trim()));
		}
		SC.close();
		
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] == .1) {
				Table = new HashTable(500009);
			}else if(alpha[i] == .5) {
				Table = new HashTable(100003);
			}else if(alpha[i] == .8) {
				Table = new HashTable(62501);
			}else if(alpha[i] == .9) {
				Table = new HashTable(55579);
			}else {
				Table = new HashTable(50207);
			}
			
			long IStart = System.currentTimeMillis();
			for (Car S : Input) {
				Table.put(S.Vin.hashCode(), S);
			}
			long IStop = System.currentTimeMillis();
			int PutCol = Table.PCollisions;
			Table.PCollisions = 0;
			
			long SSStart = System.currentTimeMillis();
			for (Car S : SSearch) {
				Table.get(S.Vin.hashCode());
			}
			long SSStop = System.currentTimeMillis();
			int SGetCol = Table.GCollisions;
			Table.GCollisions = 0;
			
			long USStart = System.currentTimeMillis();
			for (Car S : USSearch) {
				Table.get(S.Vin.hashCode());
			}
			long USStop = System.currentTimeMillis();
			int USGetCol = Table.GCollisions;
			Table.GCollisions = 0;
			
			System.out.println(
					"Type of hashing used: Random Probing\n" +
					"Hash Function used: Integer Value\n" +
					"Number of elements added: 50000\n" +
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
