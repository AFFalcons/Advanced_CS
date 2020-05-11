public class ArrayStack<T>{

	int top;
	Object[] stack;
	
	
	public  ArrayStack() {
		stack =  new Object[128];
		top = -1;
	} 
	
	
	public void push(T item) {
		if(isFull())
			throw new IllegalStateException();
		else {
			top++;
			stack[top] = item;
		}
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		T x;
		if(isEmpty())
			throw new IllegalStateException();
		else {
			x = (T)stack[top];
			top--;
		}
		if(x != null)
			return x;
		return null;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		if(isEmpty())
			throw new IllegalStateException();
		else
			return (T)stack[top];
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		if(top == 99)
			return true;
		return false;
	}

	public void clear() {
		top = -1;
	}

	
	public String ToString() {
		String vals = "";
		
		for(int i = 0; i < top + 1; i++) {
			vals += "" + stack[i];
		}
		
		return vals;
	}
	
	public String ArrayToString() {
		String vals = "";
		
		for(int i = 0; i < 100; i++) {
			vals += "" + stack[i];
		}
		
		return vals;
	}

}
