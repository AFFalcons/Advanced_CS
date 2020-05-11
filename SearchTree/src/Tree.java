
public class Tree {

	Node Root;
	
	public Tree(int First) {
		Root = new Node(First);
	}
	
	public boolean Add(int Hold) {
		if(Root == null) {
			Root = new Node(Hold);
			return true;
		}
		return AddSort(Hold, Root);
	}
	
	private boolean AddSort(int Hold, Node N) {
		if(Hold > N.Data) {
			if(N.Right == null) {
				N.Right = new Node(Hold);
				return true;
			}else {
				return AddSort(Hold, N.Right);
			}
		} else {
			if(N.Left == null) {
				N.Left = new Node(Hold);
				return true;
			}else {
				return AddSort(Hold, N.Left);
			}
		}
	}
	
	public void Print() {
		PrintTree(Root, 0);
		System.out.println();
		InOrder(Root);
		System.out.println();
	}
	
	private void PrintTree(Node N, int spaces) {
		int pass = spaces + 1;
		if(N.Right != null) PrintTree(N.Right, pass);
		for (int i = 0; i < spaces; i++) {
			System.out.print("  ");
		}
		System.out.println(N.Data + "");
		if(N.Left != null) PrintTree(N.Left, pass);
	}

	private void InOrder(Node N) {
		if(N.Left != null) InOrder(N.Left);
		System.out.print(N.Data + ",");
		if(N.Right != null) InOrder(N.Right);
	}
	
	public class Node {
		
		Node Left, Right;
		int Data;
		
		public Node(int data) {
			Data = data;
		}
	}
}
