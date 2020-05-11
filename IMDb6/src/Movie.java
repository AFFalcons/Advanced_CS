
public class Movie {
	
	private int Date;
	private String Title;
	private LinkedList<?> Actors, Directors;
	
	public Movie() {
		Date = 0;
		Title = "";
		Actors = null;
		Directors = null;
	}
	
	public Movie(int date, String title, LinkedList<?> actors, LinkedList<?> directors) {
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

	public LinkedList<?> getActors() {
		return Actors;
	}

	public void setActors(LinkedList<?> actors) {
		Actors = actors;
	}

	public LinkedList<?> getDirectors() {
		return Directors;
	}

	public void setDirectors(LinkedList<?> directors) {
		Directors = directors;
	}

	public String toString() {
		return Date + " " + Title;
	}
}
