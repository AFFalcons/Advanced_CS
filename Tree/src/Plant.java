 import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class Plant {
	
	static Hashtable<String, Double> Trees;
	static ArrayList<String> Temp;
	static Scanner SC;
	static int TC;
	static double Count;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws FileNotFoundException {
		Trees = new Hashtable<String, Double>();
		SC = new Scanner(new File("plant.dat"));
		TC = SC.nextInt();
		
		while (SC.hasNextLine()) {
			String hold = SC.nextLine();
			if(hold.length() > 0) {
				if(Trees.containsKey(hold)) {
					Trees.put(hold, Trees.remove(hold) + 1);
				}else {
					Trees.put(hold, new Double(1));
				}
				Count++;
			}else {
				Print();
			}
		}	
		Print();
	}
	
	static void Print() {
		if(!Trees.isEmpty()) {
			Temp = new ArrayList<String>();
			Trees.forEach((key, value)-> Temp.add(key));
			Collections.sort(Temp);
			for (String S0 : Temp) {
				System.out.printf("%s %.4f\n", S0, (Trees.get(S0) / Count) * 100);
			}
			Count = 0;
			Trees = new Hashtable<String, Double>();
			System.out.print("\n");
		}
	}
}
