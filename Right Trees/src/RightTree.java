import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RightTree {

	static boolean Fail;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner	SC = new Scanner(new File("righttree.dat"));
		int Count = 0;
		SC.nextLine();
		while (SC.hasNextLine()) {
			Count++;
			String Temp = SC.nextLine();
			String[] Tree = Temp.split("");
			
			isRight(Tree, 0);
			
			if(!Fail)
				System.out.println("Tree " + Count + " is a right-tree.");
			else
				System.out.println("Tree " + Count + " is a not right-tree.");
			
			Fail = false;
		}
	}
	
	public static int isRight(String[] Tree, int index) {
		int left = 0;
		int right = 0;
		
		if(index < Tree.length && Tree[index].equals("0"))
			return 0;
		
		if(!((index + 1) * 2 >= Tree.length + 1)) {
			left = isRight(Tree, ((index + 1) * 2) - 1);
		}
		
		if(!((index + 2) * 2 > Tree.length + 1)) {
			right = isRight(Tree, ((index + 1) * 2));
		}
		
		System.out.println(left + " " + right);
		
		if(left > right)
			 Fail = true;
		
		return 1 + right + left;
	}
}
