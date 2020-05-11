import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class WordLadder {

	public static Scanner SC;
	public static HashSet<String> Dictionary, Used;  
	public static LinkedList<String> Out, TS, Cur;
	public static LinkedList<LinkedList<String>> MainQ;
	
	public static final String letters = "abcdefghijklmnopqrstuvwxyz";
	public static String Check;
	static int change = 0;
	
	public static void main(String[] args) {
		Dictionary = new HashSet<String>();
		Used = new HashSet<String>();
		MainQ = new LinkedList<LinkedList<String>>();
		TS = new LinkedList<String>();
		Cur = new LinkedList<String>();
		try {
			SC = new Scanner(new File("dictionary.txt"));
			while (SC.hasNext()) 
				Dictionary.add(SC.nextLine());
			SC = new Scanner(new File("input.txt"));
			while(SC.hasNext()) {
				String[] temp = SC.nextLine().split(" ");
				if(temp[0].length() == temp[1].length()) {
					if(Dictionary.contains(temp[0]) && Dictionary.contains(temp[1])){ 
						if(!temp[0].equalsIgnoreCase(temp[1])) {
							Dictionary.remove(temp[0]);
							Used.add(temp[0]);
							Out = Check(temp[0], temp[1]);
							if(Out == null) {
								System.out.println("No Ladder");	
							}
							else {
								System.out.println("L: " + Out.toString());	
							}
						}else
							System.out.println("L: " + temp[0]);
					}
					else {
						System.out.println("No Ladder");
					}
				}else {
					System.out.println("No Ladder");
				}
				for(String x : Used) {
					Dictionary.add(x);
				}
				Used.clear();
				MainQ = new LinkedList<LinkedList<String>>();
				TS = new LinkedList<String>();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		SC.close();
	}
	
	public static LinkedList<String> Check(String s1, String s2) {
		TS.AddToFront(s1);
		MainQ.AddToEnd(TS);
		do {
			TS = MainQ.removeFirst();
			for(int i = 0; i < TS.peek(0).length(); i++) {
				for(int x = 0; x < 26; x++) {
					Cur = TS.clone();
					Check = Replace(Cur.peek(0), letters.charAt(x), i);
					if(Dictionary.contains(Check)){
						if(Check.equalsIgnoreCase(s2)) {
							Cur.AddToFront(Check);
							return Cur;
						}else {
							Dictionary.remove(Check);
							Used.add(Check);
							Cur.AddToFront(Check);
							MainQ.AddToEnd(Cur);	
							//System.out.println(Cur.toString());
						}
					}
				}
			}

		} while (MainQ.Size() != 0);
		return null;
	}
	
	public static String Replace(String start, char letter, int index) {
		char[] vals = start.toCharArray();
		vals[index] = letter;
		return String.valueOf(vals);
	}
}
