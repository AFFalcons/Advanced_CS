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
