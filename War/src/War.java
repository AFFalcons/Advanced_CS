import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class War {
	
	public static Scanner SC;
	public static RingBuffer<Integer> Player1;
	public static RingBuffer<Integer> Player2;
	public static RingBuffer<Integer> Table;
	public static HashMap<String, Integer> Map;
	public static int Count, LSize;
	public static boolean Win, War;
	public static Integer Temp1, Temp2;
	
	public static void main(String[] args) {
		BufSet();
		MapSet();
		
		try {
			SC = new Scanner(new File("war.dat"));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file. Program terminated");
		}
		
		while(SC.hasNext()) {
			String[] P1 = SC.nextLine().split(" ");
			String[] P2 = SC.nextLine().split(" ");
			
			if(P1.length == P2.length) {
				for(int i = 0; i < P1.length; i++) {
					Player1.enqueue(Map.get(P1[i].substring(0, 1)));
					Player2.enqueue(Map.get(P2[i].substring(0, 1)));
				}
				while(!Win && Count < 100000) {
					RoundSet();
					
					if(War) {
						Table.enqueue(Player1.dequeue());
						Table.enqueue(Player2.dequeue());
						War = false;
					}
					
					Temp1 = Player1.dequeue();
					Temp2 = Player2.dequeue();
					Table.enqueue(Temp1);
					Table.enqueue(Temp2);
					
					if(Temp1 > Temp2) {
						LSize = Table.Size();
						for(int i = 0; i < LSize; i++) {
							Player1.enqueue(Table.dequeue());
						}
					}else if(Temp2 > Temp1) {
						LSize = Table.Size();
						for(int i = 0; i < LSize; i++) {
							Player2.enqueue(Table.dequeue());
						}
					}else {
						War = true;
					}
					
					if(Player1.isEmpty() || Player2.isEmpty())
						Win = true;
					else 
						Count++;	
				}
				if(Count >= 100000)
					System.out.println("Tie game stopped at 100000 plays.");
				else if(Win)
					if(Player1.isEmpty())
						System.out.println("Player 2 wins!");
					else
						System.out.println("Player 1 wins!");
				else
					System.out.println("Something Messed Up. You shouldn't see this");
			}else {
				System.out.println("Player decks were not even. File read error.");
			}
			
			BufSet();
		}
	}
	
	public static void BufSet() {
		Player1 = new RingBuffer<Integer>(54);
		Player2 = new RingBuffer<Integer>(54);
		Table = new RingBuffer<Integer>(54);
		Win = false;
		War = false;
		Count = 0;
		RoundSet();
	}
	
	public static void RoundSet() {
		Temp1 = 0;
		Temp2 = 0;
		LSize = 0;
	}

	public static void MapSet() {
		Map = new HashMap<String, Integer>();
		
		Map.put("2", 0);
		Map.put("3", 1);
		Map.put("4", 2);
		Map.put("5", 3);
		Map.put("6", 4);
		Map.put("7", 5);
		Map.put("8", 6);
		Map.put("9", 7);
		Map.put("T", 8);
		Map.put("J", 9);
		Map.put("Q", 10);
		Map.put("K", 11);
		Map.put("A", 12);
	}
}
