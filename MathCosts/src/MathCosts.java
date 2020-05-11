import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathCosts {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("mathCosts.dat"));
		
		while (true) {
			int Nums = SC.nextInt();
			
			if (Nums == 0) break;
			
			ArrayList<Integer> List = new ArrayList<Integer>();
			
			for (int i = 0; i < Nums; i++) 
				List.add(SC.nextInt());
			
			System.out.println(Solver(List));
		}
	}
	
	public static int Solver(ArrayList<Integer> List) {
		PriorityQueue<Integer> Queue = new PriorityQueue<Integer>();
		for (Integer Hold : List) 
			Queue.add(Hold);
		
		int Work = 0;
        while(Queue.size() >= 2)
        {
            int a = Queue.poll();
            int b = Queue.poll();

            Queue.add(a + b);
            Work += a + b;
        }

        return Work;
	}
}
