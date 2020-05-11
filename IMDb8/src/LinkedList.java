
public class LinkedList<T> {
	
	private Node Head;
	private int Count;

	public LinkedList() {
		Head = null;
		Count = 0;
	}
	
	public void Add(T data) {
		Node temp = new Node(data);
		
		if(Head != null)
			temp.setNextPtr(Head);
		Head = temp;
		Count++;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int Index) {
		Node Temp = Head;
		if(Index == 0) {
			return (T)Head.Get();
		}else if(Count >= Index && Index > 0){
			for(int i = 0; i < Index; i++) {
				Temp = Temp.getNextPtr();
			}
			return (T)Temp.Get();
		}
		return null;
	}

	public int Size() {
		return Count;
	}
	
	public class Node {

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
