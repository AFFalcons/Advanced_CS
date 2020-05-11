
public class LinkedList {
	
	private Node Head;
	private int Count;

	public LinkedList() {
		Head = null;
		Count = 0;
	}
	
	public void Add(Object data) {
		Node temp = new Node(data);
		
		if(Head != null)
			temp.setNextPtr(Head);
		Head = temp;
		Count++;
	}
	
	public Actor get(int Index) {
		Node Temp = Head;
		if(Index == 0) {
			return (Actor)Head.Get();
		}else if(Count >= Index && Index > 0){
			for(int i = 0; i < Index; i++) {
				Temp = Temp.getNextPtr();
			}
			return (Actor)Temp.Get();
		}
		return null;
	}

	public int Size() {
		return Count;
	}
}
