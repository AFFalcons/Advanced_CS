public class Car {

	VIN Vin;
	String Year;
	String Make;
	String COO;
	
	public Car(String Vin, String Year, String Make, String COO) {
		this.Vin = new VIN(Vin);
		this.Year = Year;
		this.Make = Make;
		this.COO = COO;
	}
	
	public String toString() {
		return Vin.toString() + ", " + Year + ", " + Make + ", " + COO;
	}
}
