import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Paver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner SC = new Scanner(new File("paver.dat"));
		int cases = SC.nextInt();
		SC.nextLine();
		for (int i = 0; i < cases; i++) {
			int price = SC.nextInt();
			SC.nextLine();
		}		
	}
	
	public static int[][] buildBlankMatrix(int size){
		if(size == 0) return null;
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) 
			for (int j = 0; j < matrix[i].length; j++) 
				matrix[i][j] = -1;
		return matrix;
	}
}
