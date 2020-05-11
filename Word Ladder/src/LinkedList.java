public class LinkedList<E> {
	
	private Node Head;
	private Node Tail;
	private int Count;

	public LinkedList() {
		Head = null;
		Tail = null;
		Count = 0;
	}
	
	public void AddToFront(E data) {
		if(Count == 0) {
			Head = new Node(data);
			Tail = Head;
		}else {
			Node temp = new Node(data);
			temp.setNextPtr(Head);
			Head = temp;
		}
		Count++;
	}
	
	public void AddToEnd(E data) {
		if(Count == 0) {
			Count++;
			Head = new Node(data);
			Tail = Head;
		}else {
			Count++;
			Node temp = new Node(data);
			Tail.setNextPtr(temp);
			Tail = Tail.getNextPtr();
		}
	}
	
	@SuppressWarnings("unchecked")
	public E removeFirst() {
		Node temp = Head;
		if(Count > 1) {
			Head = Head.getNextPtr();
			Count--;
		}
		else
			clear();
		return (E) temp.Get();
	}
	
	@SuppressWarnings("unchecked")
	public E peek(int Index) {
		if(Size() > 0) {
			Node Temp = Head;
			if(Index == 0) {
				return (E)Head.Get();
			}else if(Count >= Index && Index > 0){
				for(int i = 0; i < Index; i++) {
					Temp = Temp.getNextPtr();
				}
				return (E)Temp.Get();
			}	
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<E> clone() {
		LinkedList<E> clone = new LinkedList<E>();
		
		 for (Node x = Head; x != null; x = x.getNextPtr())
	            clone.AddToEnd((E)x.Get());
	
		return clone;
	}

	public void clear() {
		Count = 0;
		Head = null;
		Tail = null;
	}
	
	public int Size() {
		return Count;
	}
	
	public String toString() {
		String vals = "";
		for(int i = 0; i < Size(); i++) {
			vals += peek(i).toString() + " ";
		}
		return vals;
	}
	
	public class Node{
		private Node Next;
		private Object Data;
		
		public Node() {
			Next = null;
		}
		
		public Node(Object data) {
			Next = null;
			Data = data;
		}
		
		public void Set(Object data) {
			Data = data;
		}
		
		public Object Get() {
			return Data;
		}
		
		public Node getNextPtr() {
			return Next;
		}

		public void setNextPtr(Node next) {
			Next = next;
		}
		
		public String toString() {
			return Data.toString();
		}
	}
}
