
public class NodeTester {

	private static Actor Head;
	
	public static void main(String[] args) { 
		Actor a = new Actor("A");
		Head = a;
		Actor b = new Actor("B");
		b.setNextPtr(Head);
		Head = b;
		Actor c = new Actor("C");
		c.setNextPtr(Head);
		Head = c;
		Actor d = new Actor("D");
		d.setNextPtr(Head);
		Head = d;
		Actor e = new Actor("E");
		e.setNextPtr(Head);
		Head = e;
		
		Actor Current = Head;
		while (Current != null) {
			System.out.println(Current.toSting());
			Current = Current.getNextPtr();
		}
		
		System.out.println(Head.toSting());
	}
}
