import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface {

	//ArrayList<T> elements;
	T elements[];
	int head, tail, size, count;
	
	public NotationQueue(int size){
		this.size=size;
	//	elements = new ArrayList<T>(size);
		elements = (T[])new Object[size];
		head = tail = count = 0;
	}
	
	public NotationQueue() {
		this(0);
	}
	

	public NotationQueue(ArrayList<String> aList) {
		this.size=aList.size();
		this.count=aList.size();
	}

	@Override
	public boolean isEmpty() {
		if (head==tail && count<elements.length) 
			return true;
		else 
			return false; 
	}

	@Override
	public boolean isFull() {
		if(head==tail && count==elements.length)
			return true;
		else 
			return false;
	}

	@Override
	public Object dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) 
			throw new QueueUnderflowException();
		
		T result =elements[head];
		if (head== elements.length-1) 
			head=0;
		 else
			head++;
		
		count--;
		return result;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (isFull()) 
			throw new QueueOverflowException();
		
		elements[tail]= (T) e;
		if (tail== elements.length-1) 
			tail=0;
		 else
			tail++;
		count++;
		return true;
		
		
	}

	@Override
	public String toString(String delimiter) {
		String result = "";
		for( int i=0;i<elements.length;i++) {
			if (i==elements.length-1)
				result+=elements;
			else 
				result += elements[i] + delimiter;
			 
		}
		return null;
	}

	
		
	}


