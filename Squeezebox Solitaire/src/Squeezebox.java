import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Squeezebox {

	static HashMap<String, Integer> Map;
	static Scanner SC;
	static String S1, S2;
	static boolean Check;
	static String[] Temp; 
	static ArrayList<ArrayList<Card>> Table;
	static ArrayList<Card> CardTemp, TableHold, TableHold2;
	
	public static void main(String[] args) throws IOException{
		map_Set();
		SC = new Scanner(new File("input.dat"));
		
		while (SC.hasNext()) {
			CardTemp = new ArrayList<Card>();
			S1 = SC.nextLine();
			if(!S1.equalsIgnoreCase("#")) {
				S2 = SC.nextLine();
				Temp = S1.split(" ");
				for(int i = 0; i < Temp.length; i++)
					CardTemp.add(new Card(Temp[i].substring(1, 2), Map.get(Temp[i].substring(0, 1))));
				Temp = S2.split(" ");
				for(int i = 0; i < Temp.length; i++)
					CardTemp.add(new Card(Temp[i].substring(1, 2), Map.get(Temp[i].substring(0, 1))));
				
				Table = Play(CardTemp);
				System.out.print(Table.size() + " piles remaining: ");
				for (ArrayList<Card> Hold : Table) 
					System.out.print(Hold.size() + " ");
				System.out.println();
			}
		}
	}

	public static ArrayList<ArrayList<Card>> Play(ArrayList<Card> In) {
		ArrayList<ArrayList<Card>> CTable = new ArrayList<ArrayList<Card>>();
		for (Card Hold : In) {
			TableHold = new ArrayList<Card>();
			TableHold.add(Hold);
			CTable.add(TableHold);
		}
		do {
			Check = false;
			for (int i = 1; i < CTable.size(); i++) {
				
				if(i > 2) {
					TableHold = CTable.remove(i);
					TableHold2 = CTable.remove(i - 3);
					
					if(TableHold.get(TableHold.size() - 1).getVal() == TableHold2.get(TableHold2.size() - 1).getVal() ||
							TableHold.get(TableHold.size() - 1).getType().equals(TableHold2.get(TableHold2.size() - 1).getType())) {
						Check = true;
						TableHold2.add(TableHold.remove(TableHold.size() - 1));
					}
					
					CTable.add(i - 3, TableHold2);
					CTable.add(i, TableHold);
				}
				
				if(Check)
					break;
				
				TableHold = CTable.remove(i);
				TableHold2 = CTable.remove(i - 1);
				
				if(TableHold.get(TableHold.size() - 1).getVal() == TableHold2.get(TableHold2.size() - 1).getVal() ||
						TableHold.get(TableHold.size() - 1).getType().equals(TableHold2.get(TableHold2.size() - 1).getType())) {
					Check = true;
					TableHold2.add(TableHold.remove(TableHold.size() - 1));
				}
				
				CTable.add(i - 1, TableHold2);
				CTable.add(i, TableHold);
				
				if(Check)
					break;
			}
			for (int i = CTable.size() - 1; i >= 0; i--) {
				if(CTable.get(i).size() == 0)
					CTable.remove(i);
			}
		} while (Check);
		return CTable;
	}
	
	public static void map_Set() {
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
