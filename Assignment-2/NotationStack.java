import java.util.ArrayList;

public class NotationStack<T> implements StackInterface {

	private ArrayList<T> elements;
	private int head,top,maxSize;
	
	
	public NotationStack(int size){
		this.maxSize=size;
		elements = new ArrayList<T>(size);
		head = top  = 0;
	}
	
	public NotationStack() {
		this(10);
		
	}
	

	public NotationStack(ArrayList<String> aList) {
		this.elements=(ArrayList<T>) aList;
		
	}

	@Override
	public boolean isEmpty() {
		if (elements.size()==0) 
			return true;
		else 
			return false; 
	}

	@Override
	public boolean isFull() {
		if(elements.size()==maxSize)
			return true;
		else 
			return false;
	}

	@Override
	public Object pop() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}else {
			T result=elements.get(elements.size()-1);
		elements.remove(elements.size()-1);
		return result;
			}
		
	}

	@Override
	public Object top() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}else {
		
		return elements.get(elements.size()-1);
			}
	}

	@Override
	public int size() {
		return elements.size();
		
	}

	@Override
	public boolean push(Object e) throws StackOverflowException {
		if (this.isFull())
			throw new StackOverflowException();
		else
			elements.add((T) e);
		return true;
	}

	@Override
	public String toString(String delimiter) {
		String result = "";
		for (T ele:elements) {
			if(elements.indexOf(ele)==elements.size()-1)
				result+=ele;
			else
			result += ele + delimiter;
			 
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result="";
		for (T t:elements)
			result+=t;
		return result;
	}

}
