
public class NodeTester {

	private static Node head; 
	
	public static void main(String[] args) {
		head = null;
		
		Actor A = new Actor("A");
		Node NA = new Node(A);
		NA.setNextPtr(head);
		head = NA;
		
		Actor B = new Actor("B");
		Node NB = new Node(B);
		NB.setNextPtr(head);
		head = NB;
		
		Actor C = new Actor("C");
		Node NC = new Node(C);
		NC.setNextPtr(head);
		head = NC;
		
		Actor D = new Actor("D");
		Node ND = new Node(D);
		ND.setNextPtr(head);
		head = ND;
		
		Actor E = new Actor("E");
		Node NE = new Node(E);
		NE.setNextPtr(head);
		head = NE;
		
		Node current = head;
		while(current != null) {
			Actor temp = (Actor)current.Get();
			System.out.println(temp.toSting());
			current = current.getNextPtr();
		}
		Actor temp = (Actor)head.Get();
		System.out.println(temp.toSting());
	}
}
