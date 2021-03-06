import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scooby {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("scooby.dat"));
		
		int run = SC.nextInt();
		SC.nextLine();
		for (int i = 0; i < run; i++) {
			String paths = SC.nextLine();
			String check = SC.nextLine();
			System.out.println(checkPath(paths, check)); 
		}
	}
	
	public static String checkPath(String lPaths, String lCheck) {
		String[] Paths = lPaths.split(" ");
		ArrayList<String> Temp = new ArrayList<String>();
		for (String s1 : Paths) {
			String[] Break = s1.split("");
			for (String s2 : Break) {
				if(!Temp.contains(s2))
					Temp.add(s2);
			}
		}
		boolean[][] table = new boolean[Temp.size()][Temp.size()];
		for (String s1 : Paths) {
			String[] Break = s1.split("");
			int index1 = Temp.indexOf(Break[0]);
			int index2 = Temp.indexOf(Break[1]);
			table[index1][index2] = true;
			table[index2][index1] = true;
			
		}
		String[] Break = lCheck.split("");
		int start = Temp.indexOf(Break[0]);
		int end = Temp.indexOf(Break[1]);
		
		if(start < 0 || end < 0) return "no";
		
		ArrayList<Integer> used = new ArrayList<Integer>();
		
		return Tunnel(start, end, table, used);
	}
	
	public static String Tunnel(int Start, int End, boolean[][] matrix, ArrayList<Integer> used) {
		if(matrix[Start][End]) return "yes";
		used.add(Start);
		for(int i = 0; i < matrix[Start].length; i++) {
			if(matrix[Start][i] && !used.contains(i))
				if(Tunnel(i, End, matrix, used).equals("yes")) return "yes";
		}
		return "no";
	}
}
