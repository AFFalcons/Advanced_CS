

public class Line {

	double XS, XE, YS, YE;
	
	public Line(double XS, double YS, double XE, double YE) {
		this.XE = XE;
		this.XS = XS;
		this.YE = YE;
		this.YS = YS;
	}
	
	public void draw() {
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.setPenRadius(.001);
		StdDraw.line(XS, YS, XE, YE);
	}
	
}
