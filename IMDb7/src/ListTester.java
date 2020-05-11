import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester {
	
	static LinkedList<Actor> Actors; 
	static LinkedList<Movie> Movies; 
	static Scanner SC;

	public static void main(String[] args) {
		Actors = new LinkedList<Actor>();
		Movies = new LinkedList<Movie>();
		
		try {
			SC = new Scanner(new File("actors.txt"));
			
			while (SC.hasNext()) {
				Actors.Add(new Actor(SC.nextLine()));				
			}
			
			for(int i = 0; i < Actors.Size(); i++) {
				System.out.println(Actors.get(i).toString()); 
			}
			
			System.out.println(Actors.get(0).toString());
			
			SC = new Scanner(new File("movies.txt"));
			
			while(SC.hasNext()) {
				String temp = SC.nextLine();
				Movies.Add(new Movie(Integer.parseInt(temp.substring(0, 4)), (String)temp.subSequence(5, 36), null, null));
			}
			
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
