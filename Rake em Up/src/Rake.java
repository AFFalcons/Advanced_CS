import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Rake {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("rake.dat"));
		
		int Case = 0;
		
		while (SC.hasNext()) {
			Case++;
			String Hold = SC.nextLine();
			if(Hold.equalsIgnoreCase("-1")) break;
			String[] str = Hold.split(" ");
			 int[] nums = new int[str.length];
            for(int i = 0; i < nums.length; i++)
                nums[i] = Integer.parseInt(str[i]);
			
            LinkedTree tree = new LinkedTree(nums);
            tree.populate();
            System.out.println("Case " + Case + ":");
            System.out.println(tree.Out());
            System.out.println();
		}
	}
}
