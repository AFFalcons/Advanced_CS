public class Actor {

	private String Name;
	private Actor Next;
	
	public Actor() {
		Name = "";
		Next = null;
	}
	public Actor(String Name) {
		this.Name = Name;
		Next = null;
	}
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Actor getNextPtr() {
		return Next;
	}
	public void setNextPtr(Actor next) {
		Next = next;
	}
	public String toSting() {
		return Name;
	}
}
