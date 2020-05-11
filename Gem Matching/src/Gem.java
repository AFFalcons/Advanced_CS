import java.awt.Font;
import java.util.Random;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{	
	private GemType Type;
	private int Points;
	
	public Gem() {
		Random rand = new Random();
		int x;
		x = rand.nextInt(3) + 1;
		if(x == 1)
			Type = GemType.GREEN;
		else if(x == 2)
			Type = GemType.BLUE;
		else
			Type = GemType.ORANGE;
		
		x = rand.nextInt(11);
		Points = x * 5;
		
		rand = null;
	}
	
	public Gem(GemType Col, int Val) {
		Type = Col;
		Points = Val;
	}
	
	public void draw(double x, double y) {
		StdDraw.setPenColor(StdDraw.WHITE);
		
		if(Type.equals(GemType.BLUE)) {
			StdDraw.picture(x, y, "gem_blue.png");
			StdDraw.text(x, y, "" + Points);
		}
		if(Type.equals(GemType.ORANGE)) {
			StdDraw.picture(x, y, "gem_orange.png");
			StdDraw.text(x, y, "" + Points);
		}
		if(Type.equals(GemType.GREEN)) {
			StdDraw.picture(x, y, "gem_green.png");
			StdDraw.text(x, y, "" + Points);
		}
	}
		
	public GemType getType() {
		return Type;
	}

	public int getPoints() {
		return Points;
	}
	
	public String toString() {
		return Type.toString() + " " + Points;
	}
}
