import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Goat {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("goat.dat"));
		int Cases = SC.nextInt();
		while (Cases > 0) {
			ArrayList<Rotation> Goats = new ArrayList<Rotation>();
			int GoatC = SC.nextInt();
			SC.nextLine();
			for (int i = 0; i < GoatC; i++) {
				String Hold = SC.nextLine(); 
				//System.out.println(Hold);
				String[] Split = Hold.split(" ");
				int[] Vals = new int[Split.length - 1];
				for (int j = 0; j < Vals.length; j++) {
					Vals[j] = Integer.parseInt(Split[j + 1]);
				}
				Goats.add(new Rotation(Vals));
			}
			
			int days = 0;
			int lastday = 0;
			while(days - lastday < 10000) {
				int least = 251;
				int index = 0;
				boolean kill = true;
				for (Rotation rotation : Goats) {
					rotation.setMilk(days);
				}
				for (int i = 0; i < Goats.size(); i++) {
					if(Goats.get(i).getMilk() < least) {
						kill = true;
						least = Goats.get(i).getMilk();
						index = i;
					} else if(Goats.get(i).getMilk() == least){
						kill = false;
					}
				}
				if(kill) {
					Goats.remove(index);
					lastday = days;
				}
				days++;
			}
			
			System.out.println(Goats.size() + " " + (lastday + 1));
			
			Cases--;
		}
	}
}
