import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StarField {

	//change to hash table
	static ArrayList<Star> Stars;
	static HashTable unNamed, Con;
	
	static String[] files = {"Big Dipper.txt", "Cassiopeia.txt", "Cygnet.txt", "Bootes.txt",
			"Gemini.txt", "Hydra.txt", "Ursa Major.txt", "Ursa Minor.txt"};
	
	static String[] Cons = {"Big Dipper", "Cassiopeia", "Cygnet", "Bootes",
			"Gemini", "Hydra", "Ursa Major", "Ursa Minor", "All" , "Clear"};
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("stars.txt"));
		unNamed = new HashTable(4073);
		Con = new HashTable();
		Stars = new ArrayList<Star>();
		while (SC.hasNext()) {
			String Hold = SC.nextLine();
			String[] Split = Hold.split(" ");
			if(Split.length > 6) {
				int len = Split.length - 5;
				String names = "";
				String[] namep;
				for(int i = 0; i < len - 1; i++) {
					names += Split[i + 6] + " ";
				}
				System.out.print(names);
				namep = names.split(";");
				for (String string : namep) {
					string = string.trim();
					System.out.print(string);
					unNamed.put(hash(string), new Star(Double.parseDouble(Split[0]), Double.parseDouble(Split[1]), Double.parseDouble(Split[2]), Integer.parseInt(Split[3]), Double.parseDouble(Split[4]), string));
				}
				System.out.println();
			}else {
				unNamed.put(Integer.parseInt(Split[3]), new Star(Double.parseDouble(Split[0]), Double.parseDouble(Split[1]), Double.parseDouble(Split[2]), Integer.parseInt(Split[3]), Double.parseDouble(Split[4])));
			}
		}
		DStars();
		cCon();
		
		/*
		//Lab
		StdDraw.setCanvasSize(512, 512);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setScale(-1, 1);
		unNamed.drawS();
		Con.drawC();
		*/
		while(true) {
			if(StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();

				Constellation Temp;
				
                switch (key) {
				case '1':
					Temp = (Constellation) Con.get(hash(Cons[0]));
					Temp.draw();
					break;
				case '2':
					Temp = (Constellation) Con.get(hash(Cons[1]));
					Temp.draw();
					break;
				case '3':
					Temp = (Constellation) Con.get(hash(Cons[2]));
					Temp.draw();
					break;
				case '4':
					Temp = (Constellation) Con.get(hash(Cons[3]));
					Temp.draw();
					break;
				case '5':
					Temp = (Constellation) Con.get(hash(Cons[4]));
					Temp.draw();
					break;
				case '6':
					Temp = (Constellation) Con.get(hash(Cons[5]));
					Temp.draw();
					break;
				case '7':
					Temp = (Constellation) Con.get(hash(Cons[6]));
					Temp.draw();
					break;
				case '8':
					Temp = (Constellation) Con.get(hash(Cons[7]));
					Temp.draw();
					break;
				case '9':
					Con.drawC();
					break;
				case '0':
					DStars();
					break;
				default:
					break;
				}
			}
		}
		
	}
	
	public static int hash(String str) {
		int h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = 17 * h + str.charAt(i);
        }
        return Math.abs(h);
	}
	
	public static void cCon() throws FileNotFoundException {
		for (String FileN : files) {
			Scanner SC = new Scanner(new File(FileN));
			String str = SC.nextLine();
			ArrayList<Line> Lines = new ArrayList<Line>();
			while (SC.hasNext()) {
				String string = (String) SC.nextLine();
				String[] parts = string.split(",");
				Star SS = (Star) unNamed.get(hash(parts[0]));
				Star ES = (Star) unNamed.get(hash(parts[1]));
				Lines.add(new Line(SS.x, SS.y, ES.x, ES.y));
			}
			Con.put(hash(str), new Constellation(Lines));
		}
	}
	
	
	public static void DStars() {
		double y = .42;
		String print;
		StdDraw.setCanvasSize(768, 512);
		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setXscale(-2, 1);
		StdDraw.setYscale(-1, 1);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.textLeft(-1.98, .5, "Select a number to Draw");
		for(int i = 1; i < Cons.length + 1; i++) {
			print = (i % 10) + ": " + Cons[i - 1];
			StdDraw.textLeft(-1.98, y, print);
			y -= .08;
		}
		unNamed.drawS();
	}
}
