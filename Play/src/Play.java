import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Play {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("play.dat"));
		int cases = SC.nextInt();
		SC.nextLine();
		for (int i = 0; i < cases; i++) {
			String temp = SC.nextLine();
			String[] split = temp.split(" ");
			int n = Integer.parseInt(split[0]);
			int m = Integer.parseInt(split[1]);
			int l = Integer.parseInt(split[2]);
			boolean[] tiles = new boolean[n];
			boolean[][] table = new boolean[n][n];
			for(int x = 0; x < m; x++) {
				String temp1 = SC.nextLine();
				String[] split1 = temp1.split(" ");
				table[Integer.parseInt(split1[0]) - 1][Integer.parseInt(split1[1]) - 1] = true;
			}
			
			RingBuffer<Integer> buffer = new RingBuffer<Integer>(n);
			
			for (int x = 0; x < l; x++) {
				int drop = SC.nextInt();
				tiles[drop - 1] = true;
				buffer.enqueue(drop - 1);
				
				do {
					int test = buffer.dequeue();
					for (int j = 0; j < table[test].length; j++) {
						if(table[test][j]) {
							if(!tiles[j]) {
								tiles[j] = true;
								buffer.enqueue(j);
							}
						}
					}
				} while (!buffer.isEmpty());
				
				if(SC.hasNext()) SC.nextLine();
			}
			int count = 0;
			for (boolean bs : tiles) if(bs) count++;
			System.out.println(count);
		}
	}

}