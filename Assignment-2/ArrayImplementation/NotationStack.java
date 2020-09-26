import java.util.ArrayList;

public class NotationStack<T> implements StackInterface {

	T elements[];
	int head,top,size ,count;
	
	
	public NotationStack(int size){
		this.size=size;
		elements = (T[])new Object[size];
		head = top = count = 0;
	}
	
	public NotationStack() {
		this(10);
		
	}
	

	public NotationStack(ArrayList<String> aList) {
		this();
		
	}

	@Override
	public boolean isEmpty() {
		if(count==0)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(size==count && count!=0)
			return true;
		return false;
	}

	@Override
	public Object pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}else {
		count--;
		return elements[--top];
			}
		
	}

	@Override
	public Object top() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}else {
		
		return elements[top-1];
			}
	}

	@Override
	public int size() {
		return count;
		
	}

	@Override
	public boolean push(Object e) throws StackOverflowException {
		if (this.isFull())
			throw new StackOverflowException();
		elements[top] = (T) e;
		top++;
		count++;
		return true;
	}

	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		String result="";
		for (T t:elements)
			result+=t;
		return null;
	}

}
