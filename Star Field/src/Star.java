public class Star {

	double x, y, z, Magnitude;
	int ID;
	String names;
	
	public Star(double x, double y, double z, int id, double mag, String names) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.ID = id;
		this.Magnitude = mag;
		this.names = names;
	}
	
	public Star(double x, double y, double z, int id, double mag) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.ID = id;
		this.Magnitude = mag;
	}
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius();
		StdDraw.filledCircle(x, y, Math.abs(Magnitude / 1900));
	}
}
