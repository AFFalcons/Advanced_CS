
public class ListTester {

	public static void main(String[] args) {
		LinkedList LL = new LinkedList();
		LL.Add(new Actor("A"));
		LL.Add(new Actor("B"));
		LL.Add(new Actor("C"));
		LL.Add(new Actor("D"));
		LL.Add(new Actor("E"));
		
		for(int i = 0; i < LL.Size(); i++) {
			System.out.println(LL.get(i).toSting()); 
		}
		
		System.out.println(LL.get(0).toSting());
	}

}
