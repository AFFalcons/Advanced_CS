import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {

	static Tree tree;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("tree.dat"));
		while (SC.hasNext()) {
			tree = null;
			String Hold = SC.nextLine();
			String[] Split = Hold.split(",");
			for (String string : Split) {
				if(tree == null) {
					tree = new Tree(Integer.parseInt(string));
				} else {
					tree.Add(Integer.parseInt(string));
				}
			}
			tree.Print();
		}
	}
}
