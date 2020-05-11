public class ActorLinkedList {
	
	private Actor Head;
	private int Count;

	public ActorLinkedList() {
		Head = null;
		Count = 0;
	}
	
	public void Add(Actor AC) {
		if(Head != null)
			AC.setNextPtr(Head);
		Head = AC;
		Count++;
	}
	
	public Actor get(int Index) {
		Actor Temp = Head;
		if(Index == 0) {
			return Head;
		}else if(Count >= Index && Index > 0){
			for(int i = 0; i < Index; i++) {
				Temp = Temp.getNextPtr();
			}
			return Temp;
		}
		return null;
	}

	public int Size() {
		return Count;
	}
	
}
