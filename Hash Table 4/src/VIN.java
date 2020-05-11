public class VIN {

	String vin;

	public VIN(String vin) {
		this.vin = vin;
	}
	
	public VIN() {
		this("");
	}
	
	public boolean equals(Object o) {
		if(o instanceof VIN)
			if(vin.equals(o.toString()))
				return true;
		return false;
	}
	
	public int hashCode() {
		int h = 0;
        for (int i = 0; i < vin.length(); i++) {
            h = 17 * h + vin.charAt(i);
        }
        return Math.abs(h);
	}
	
	public String toString() {
		return vin;
	}
	
}
