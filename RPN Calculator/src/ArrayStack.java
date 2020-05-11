
public class ArrayStack implements IStack{

	int top;
	double[] stack;
	
	public  ArrayStack() {
		stack =  new double[100];
		top = -1;
	} 
	
	@Override
	public void push(double val) {
		if(top < 99) {
			stack[top + 1] = val;
			top++;	
		}
	}

	@Override
	public double pop() {
		double x = 0;
		
		if(top >= 0) {
			x = stack[top];
			top--;
		}
		
		return x;
	}

	@Override
	public double peek() {
		return stack[top];
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		if(top == -1)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(top == 99)
			return true;
		return false;
	}

	@Override
	public void clear() {
		top = -1;
	}

	
	public String ToString() {
		String vals = "";
		
		for(int i = 0; i < top + 1; i++) {
			vals += " " + stack[i];
		}
		
		return vals;
	}
	
	@Override
	public String ArrayToString() {
		String vals = "";
		
		for(int i = 0; i < 100; i++) {
			vals += " " + stack[i];
		}
		
		return vals;
	}

}
