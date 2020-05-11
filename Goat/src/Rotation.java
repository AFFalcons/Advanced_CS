
public class Rotation {

	int[] sequance;
	int curval;
	
	public Rotation(int[] sequance) {
		this.sequance = sequance;
	}
	
	public void setMilk(int x) {
		curval = sequance[x % sequance.length]; 
	}
	
	public int getMilk() {
		return curval;
	}
}
