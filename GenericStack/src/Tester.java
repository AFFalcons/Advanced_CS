import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Tester {

	static ArrayStack<Double> AS;
	static Scanner SC;
	
	public static void main(String[] args) {
		AS = new ArrayStack<Double>();
		
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
					try {
						AS.push(Divide());
					}
					catch(IllegalStateException e) {
						return "Invalid";
					}
					break;
				case "*":
					try {
						AS.push(Multiply());
					}
					catch(IllegalStateException e) {
						return "Invalid";
					}
					break;
				case "-":
					try {
						AS.push(Minus());
					}
					catch(IllegalStateException e) {
						return "Invalid";
					}
					break;
				case "+":
					try {
						AS.push(Plus());
					}
					catch(IllegalStateException e) {
						return "Invalid";
					}
					break;
				default:
					AS.push(Double.parseDouble(args[i]));
					break;
			}
		}
		return "" + AS.peek();
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