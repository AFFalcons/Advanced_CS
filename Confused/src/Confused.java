import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Confused {

	static ArrayStack<String> AS;
	static Scanner SC;
	static String c1, c2;
	
	public static void main(String[] args) {
		AS = new ArrayStack<String>();
		c1 = "(";
		c2 = "[";
		
		try {
			SC = new Scanner(new File("confused.dat"));
			int count = SC.nextInt();
			SC.nextLine();
			
			
			for(int i = 0; i < count; i++) {
				AS.clear();
				
				String temp = SC.nextLine();
				temp = temp.replaceAll("\\s", "");
				
				String[] parts = temp.split("");
				
				System.out.println(CheckValid(parts));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
			e.printStackTrace();
		}
	}

	public static String CheckValid(String[] parts) {
		for(int i = 0; i < parts.length; i++){		
			if(AS.isEmpty() && (parts[i].length() > 0)) {
				try {
					AS.push(parts[i]);
				}catch(IllegalStateException e) {
					e.printStackTrace();
					return "No";
				}
			}else if(parts[i].length() > 0){
				if(parts[i].equals(")")) {
					if(c1.equals(AS.peek())) {
						AS.pop();
					}else {
						try {
							AS.push(parts[i]);
						}catch(IllegalStateException e) {
							e.printStackTrace();
							return "No";
						}
					}
				}else if(parts[i].equals("]")){
					if(c2.equals(AS.peek())) {
						AS.pop();
					}else {
						try {
							AS.push(parts[i]);
						}catch(IllegalStateException e) {
							e.printStackTrace();
							return "No";
						}
					}
				}else if(!parts[i].equalsIgnoreCase(" ")){
					try {
						AS.push(parts[i]);
					}catch(IllegalStateException e) {
						e.printStackTrace();
						return "No";
					}
				}
			}
		}

		if(AS.size() <= 0)
			return "Yes";
		return "No";
	}	
}
