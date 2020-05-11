import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Tester {

	static ArrayStack AS;
	static Scanner SC;
	
	public static void main(String[] args) {
		AS = new ArrayStack();
		
		try {
			SC = new Scanner(new File("expressions.txt"));
			int count = SC.nextInt();
			SC.nextLine();
			
			
			for(int i = 0; i < count; i++) {
				AS.clear();
				
				String temp = SC.nextLine();
				
				String[] parts = temp.split(" ");
				
				System.out.println(math(parts));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Can not find file. Program was ended.");
			e.printStackTrace();
		}
	}
	
	public static String math(String[] args) {
		for(int i = 0; i < args.length; i++) {
			switch(args[i]) {
				case "/":
					if(AS.size() > 1) {
						AS.push(Divide());
					}else {
						return "Invalid";
					}
					break;
				case "*":
					if(AS.size() > 1) {
						AS.push(Multiply());
					}else {
						return "Invalid";
					}
					break;
				case "-":
					if(AS.size() > 1) {
						AS.push(Minus());
					}else {
						return "Invalid";
					}
					break;
				case "+":
					if(AS.size() > 1) {
						AS.push(Plus());
					}else {
						return "Invalid";
					}
					break;
				default:
					AS.push(Double.parseDouble(args[i]));
					break;
			}
		}
		return "" + AS.pop();
	}
	
	public static double Plus() {
		double a = AS.pop();
		double b = AS.pop();
		return a + b;
	}
	
	public static double Minus() {
		double a = AS.pop();
		double b = AS.pop();
		return b - a;
	}
	
	public static double Divide() {
		double a = AS.pop();
		double b = AS.pop();
		return b / a;
	}
	
	public static double Multiply() {
		double a = AS.pop();
		double b = AS.pop();
		return a * b;
	}
}
