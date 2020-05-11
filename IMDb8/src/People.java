public class People {

	private String Name;

	public People() {
		Name = "";
	}

	public People(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String toString() {
		return Name;
	}
}