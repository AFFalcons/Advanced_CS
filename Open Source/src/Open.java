import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class Open {

	static Hashtable<String, Project> Projects;
	//<Peraon, Project>
	static Hashtable<String, String> Names;
	static Collection<Project> Holding;
	static String TName;
	static Project Build;
	
	public static void main(String[] args) throws IOException{
		Scanner SC = new Scanner(new File("open.dat"));

		Projects = new Hashtable<String, Project>();
		Names = new Hashtable<String, String>();
		
		while (SC.hasNextLine()) {
			String hold = SC.nextLine();
			if(hold.equalsIgnoreCase("1")) {
				Projects.put(TName, Build);
				Sort();
				Build = null;
				TName = null;
				Projects = new Hashtable<String, Project>();
				Names = new Hashtable<String, String>();
				System.out.println();
			}else if(hold.equalsIgnoreCase("0")) {
				break;
			}else {
				if(Character.isUpperCase(hold.charAt(0))) {
					if(Build != null) {
						Projects.put(TName, Build);
						TName = hold;
						Build = new Project(TName);
					}else {
						TName = hold;
						Build = new Project(TName);
					}
				}else {
					if(Names.containsKey(hold)) {
						if(!Names.get(hold).equalsIgnoreCase(TName))
							Projects.get(Names.get(hold)).removeName(hold);
					}else {
						Build.addName(hold);
						Names.put(hold, TName);
					}
				}
			}
		}
		SC.close();
	}
	
	static void Sort() {
		int Top = 0;
		Hashtable<Integer, ArrayList<String>> Sorting = new Hashtable<Integer, ArrayList<String>>();
		ArrayList<String> Hold = new ArrayList<String>(Projects.keySet());
		for (String string : Hold) {
			if(Sorting.containsKey(Projects.get(string).getSize())) {
				ArrayList<String> Put = Sorting.get(Projects.get(string).getSize());
				Put.add(string);
				Sorting.put(Projects.get(string).getSize(), Put);
			}else {
				if(Projects.get(string).getSize() > Top) {
					Top = Projects.get(string).getSize();
					ArrayList<String> Put = new ArrayList<String>();
					Put.add(string);
					Sorting.put(Projects.get(string).getSize(), Put);
				}else {
					ArrayList<String> Put = new ArrayList<String>();
					Put.add(string);
					Sorting.put(Projects.get(string).getSize(), Put);
				}
			}
		}
		for(Integer i = Top; i >= 0; i--) {
			if(Sorting.containsKey(i)) {
				ArrayList<String> hold = Sorting.get(i);
				Collections.sort(hold);
				for (String string : hold) {
					Projects.get(string).out();
				}
			}
		}
	}
	
}
