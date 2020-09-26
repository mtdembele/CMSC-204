import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface {

	//ArrayList<T> elements;
	private ArrayList<T> elements;
	private int head, tail, maxSize, count;
	
	public NotationQueue(int size){
		this.maxSize=size;
	//	elements = new ArrayList<T>(size);
		elements = new ArrayList<T>(size);
		head = tail  = 0;
	}
	
	public NotationQueue() {
		this(0);
	}
	

	public NotationQueue(ArrayList<String> aList) {
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
	public Object dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) 
			throw new QueueUnderflowException();
		
		T result =elements.get(0);
		elements.remove(0);
		return result;
	}

	@Override
	public int size() {
		int result=elements.size();
		return result;
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (isFull()) 
			throw new QueueOverflowException();
		
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
		String result = "";
		for (T ele:elements) {
				result+=ele;
		}
		return result;
	}

	
		
	}


