
public class Movie {
	
	private int Date;
	private String Title;
	private LinkedList<People> Actors, Directors;
	
	public Movie() {
		Date = 0;
		Title = "";
		Actors = null;
		Directors = null;
	}
	
	public Movie(int date, String title, LinkedList<People> actors, LinkedList<People> directors) {
		Date = date;
		Title = title;
		Actors = actors;
		Directors = directors;
	}
	
	public int getDate() {
		return Date;
	}

	public void setDate(int date) {
		Date = date;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public LinkedList<People> getActors() {
		return Actors;
	}
	
	public String[] getActorsAsArray() {
		String[] Names = new String[Actors.Size()];
		for(int i = 0; i < Actors.Size(); i++) {
			Names[i] = Actors.get(i).getName();
		}
		return Names;
	}

	public void setActors(LinkedList<People> actors) {
		Actors = actors;
	}

	public LinkedList<People> getDirectors() {
		return Directors;
	}
	
	public String[] getDirectorsAsArray() {
		String[] Names = new String[Directors.Size()];
		for(int i = 0; i < Directors.Size(); i++) {
			Names[i] = Directors.get(i).getName();
		}
		return Names;
	}

	public void setDirectors(LinkedList<People> directors) {
		Directors = directors;
	}

	public String toString() {
		return Date + " " + Title;
	}
}
