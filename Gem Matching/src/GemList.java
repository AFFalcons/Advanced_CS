public class GemList 
{
	private int Size;
	private Node Head;
	
	public GemList() {
		Size = 0;
		Head = null;
	}
	
	public int size() {
		return Size;
	}
	
	public void draw(double y) {
		Node Temp = Head;
		for(int i = 0; i < Size; i++) {
			Temp.getGem().draw(GemGame.indexToX(i), y); 
			Temp = Temp.getNext();
		}
	}
	
	public void insertBefore(Gem gem, int Index) {
		Node node = new Node();
		node.gem = gem;
		
		Node current = Head;
		
		if(Index > Size) {
			Index = Size;
		}
		if(current == null) {
			Head = node;
		}else {
			if(Index == 0) {
				Node next = Head;
				Head = current;
				Head.next = next;
			}else if(Index == 1) {
				Node prev = Head;
				Node next = prev.next;
				prev.next = node;
				node.next = next;
			}else {
				for(int i = 0; i < Index - 1; i++) {
					current = current.next;
				}
				Node prev = current;
				Node next = prev.next;
				prev.next = node;
				node.next = next;
			}
		}
		Size++;
	}
	
	public String toString() {
		String Hold = "";
		GemType CGem = null;
		if(!(Head == null)) {
			Node Temp = Head;
			for(int i = 0; i < Size; i++) {
				if(!(CGem == Temp.getGem().getType())) {
					Hold += " " + Temp.getGem().getType() + "-->";
					CGem = Temp.getGem().getType();
				}
				Temp = Temp.getNext();
			}
			return Hold.substring(1, Hold.length() - 3);
		}
		return "<none>";
	}
	
	public int score() {
		int Score = 0;
		int Multiply = 0;
		int LHold = 0;
		GemType CGem = null;
		if(!(Head == null)) {
			Node Temp = Head;
			for(int i = 0; i < Size; i++) {
				if(CGem == Temp.gem.getType()) {
					LHold += Temp.gem.getPoints();
					Multiply++;
					CGem = Temp.gem.getType();
				}else {
					Score += (Multiply * LHold);
					Multiply = 0;
					LHold = 0;
					CGem = Temp.gem.getType();
					Multiply++;
					LHold += Temp.gem.getPoints();
				}
				Temp = Temp.next;
			}
			Score += (Multiply * LHold);
		}
		return Score;
	}
	
	private class Node {
		private Gem gem;
		private Node next;
		
		public Node(Gem Data, Node Next) {
			this.gem = Data;
			this.next = Next;
		}
		
		public Node() {
			this.gem = null;
			this.next = null;
		}
		
		public Gem getGem() { return gem; }
		public void setGem(Gem gem) { this.gem = gem; }
		public Node getNext() { return next; }
		public void setNext(Node next) { this.next = next; }
	}
	
	public static void main(String [] args)
	{
  		GemList list = new GemList();
  		System.out.println(list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.9);		
  		
  		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
  		System.out.println("\n" + list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.8);
  		
  		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
  		System.out.println("\n" + list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.7);
  		
  		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
  		System.out.println("\n" + list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.6);
  		
  		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
  		System.out.println("\n" + list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.5);
  		
  		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
  		System.out.println("\n" + list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.4);
  		
  		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
  		System.out.println("\n" + list);
  		System.out.println("size = " + list.size() + ", score = " + list.score());
  		list.draw(0.3);		
	}	
}
