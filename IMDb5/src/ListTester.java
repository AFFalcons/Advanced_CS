import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListTester {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		try {
			Scanner SC = new Scanner(new File("actors.txt"));
			
			while (SC.hasNext()) {
				LL.Add(new Actor(SC.nextLine()));				
			}
			
			for(int i = 0; i < LL.Size(); i++) {
				System.out.println(LL.get(i).toSting()); 
			}
			
			System.out.println(LL.get(0).toSting());
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file. Program ended");
			e.printStackTrace();
		}
	}

}
