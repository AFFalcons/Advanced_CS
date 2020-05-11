import java.util.ArrayList;

public class Constellation {

	ArrayList<Line> Lines;
	
	public Constellation(ArrayList<Line> Lines) {
		this.Lines = Lines;
	}
	
	public void draw() {
		for (Line line : Lines) {
			line.draw();
		}
	}
}
