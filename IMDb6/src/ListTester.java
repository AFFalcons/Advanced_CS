import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		LinkedList<Actor> Actors = new LinkedList<Actor>();
		LinkedList<Movie> Movies = new LinkedList<Movie>();
		
		try {
			Scanner SC = new Scanner(new File("actors.txt"));
			
			while (SC.hasNext()) {
				Actors.Add(new Actor(SC.nextLine()));				
			}
			
			for(int i = 0; i < Actors.Size(); i++) {
				System.out.println(Actors.get(i).toSting()); 
			}
			
			System.out.println(Actors.get(0).toSting());
			
			Movies.Add(new Movie(1999, "A", null, null));
			Movies.Add(new Movie(1999, "B", null, null));
			Movies.Add(new Movie(1999, "C", null, null));
			Movies.Add(new Movie(1999, "D", null, null));
			Movies.Add(new Movie(1999, "E", null, null));
			
			for(int i = 0; i < Movies.Size(); i++) {
				System.out.println(Movies.get(i).toString()); 
			}
			
			System.out.println(Movies.get(0).toString());
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file. Program ended");
			e.printStackTrace();
		}
	}

}
