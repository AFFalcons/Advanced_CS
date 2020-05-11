import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester {
	
	static LinkedList<People> Actors; 
	static LinkedList<Movie> Movies; 
	static Scanner SC;

	public static void main(String[] args) {
		Actors = new LinkedList<People>();
		Movies = new LinkedList<Movie>();
		
		try {
			SC = new Scanner(new File("actors.txt"));
			
			while (SC.hasNext()) {
				Actors.Add(new People(SC.nextLine().trim()));				
			}

			SC = new Scanner(new File("movies.txt"));
			
			while(SC.hasNext()) {
				String temp = SC.nextLine();
				Movies.Add(new Movie(Integer.parseInt(temp.substring(0, 4)), (String)temp.substring(5, 36).trim(), ParsePeople((String)temp.substring(38, 83)), ParsePeople((String)temp.substring(89))));
			}
			
			for(int i = 0; i < Actors.Size(); i++) {
				System.out.println(Actors.get(i).toString() + "-");
				for(int x = 0; x < Movies.Size(); x++) {
					String[] Temp = Movies.get(x).getActorsAsArray();
					for(int z = 0; z < Temp.length; z++) {
						if(Temp[z].equalsIgnoreCase(Actors.get(i).getName()))
							System.out.println("	-" + Movies.get(x).toString());
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file. Program ended");
			e.printStackTrace();
		}
	}

	public static LinkedList<People> ParsePeople(String Names){
		String[] Temp = Names.split(",");
		LinkedList<People> TempLL= new LinkedList<People>();
		for(int i = 0; i < Temp.length; i++) {
			TempLL.Add(new People(Temp[i].trim()));
		}
		return TempLL;
	}
}
