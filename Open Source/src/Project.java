import java.util.ArrayList;

public class Project {

	ArrayList<String> Names;
	public String Title;
	
	public Project(String title) {
		Title = title;
		Names = new ArrayList<String>();
	}
	
	public void addName(String s1) {
		Names.add(s1);
	}
	
	public void removeName(String s1) {
		if(Names.contains(s1))
			Names.remove(s1);
	}
	
	public int getSize() {
		return Names.size();
	}
	
	public void out() {
		System.out.println(Title + " " + Names.size());
	}
}
