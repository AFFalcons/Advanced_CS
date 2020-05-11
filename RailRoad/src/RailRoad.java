import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RailRoad {

	static ArrayStack<String> AS;
	static Scanner SC;
	static int length;
	static boolean check;
	static String temp;
	
	public static void main(String[] args) {
		AS = new ArrayStack<String>();
		length = 0;
		
		try {
			SC = new Scanner(new File("railroad.dat"));
			temp = SC.nextLine();
			length = Integer.parseInt(temp);
			
			while(SC.hasNext()) {
				temp = SC.nextLine();
				AS.clear();
				if(!temp.equalsIgnoreCase("0")) {
					if(!(temp.length() < length)) {
						System.out.println(Rail(temp, length));
					}else {
						length = Integer.parseInt(temp);
					}
				}else {
					System.out.println("");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file. Program will be terminated");
		}
	}
	
	public static String Rail(String out, int leng) {
		String[] output = out.split(" ");
		String[] input = new String[leng];
		int pos1 = 0, pos2 = 0; //p1 = in; p2 = out
		check = false;
		for(int i = 1; i <= length; i++) {
			input[i - 1] = "" + i;
		}
		
		while(!check) {
			if(!AS.isEmpty()) {
				if(AS.peek().equals(output[pos2])) {
					AS.pop();
					pos2++;
					if(pos2 == leng - 1)
						check = true;
				}else {
					if(!(pos1 == leng)) {
						AS.push(input[pos1]);
						pos1++;
					}else {
						return "No";
					}
				}
			}else {
				if(!(pos1 == leng)) {
					AS.push(input[pos1]);
					pos1++;
				}else {
					return "No";
				}
			}
		}
		if(check)
			return "Yes";
		return "No";
	}
}
