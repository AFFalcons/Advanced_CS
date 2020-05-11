public class Actor {

	private String Name;

	public Actor() {
		Name = "";
	}

	public Actor(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String toSting() {
		return Name;
	}
}