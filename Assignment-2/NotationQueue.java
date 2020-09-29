import java.util.ArrayList;
/**
 * 
 * @author Mohammad
 *
 * @param <T>
 */
public class NotationQueue<T> implements QueueInterface {

	
	private ArrayList<T> elements;
	private int maxSize=100;
	/**
	 * size Constructor
	 * @param size max size of Queue
	 */
	public NotationQueue(int size){
		this.maxSize=size;
	
		elements = new ArrayList<T>(size);
		
	}
	/**
	 * Default constructor
	 */
	public NotationQueue() {
		this(100);
	}
	
/**
 * Copies an ArrayList for queue
 * @param aList
 */
	public NotationQueue(ArrayList<T> aList) {
		this.elements=(ArrayList<T>) aList;
		
	}
	/** Checks if queue is empty
	 * @return true if array is empty, false if array is not empty
	 */
	@Override
	public boolean isEmpty() {
		if (elements.size()==0) 
			return true;
		else 
			return false; 
	}
/**checks if queue is full
 * @return true if queue is full, false if queue is not full
 */
	@Override
	public boolean isFull() {
		if(elements.size()==maxSize)
			return true;
		else 
			return false;
	}
/**Dequeue queue
 * @return object that is dequeued
 * @throws QueueUnderFlowException
 */
	@Override
	public Object dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) 
			throw new QueueUnderflowException();
		
		T result =elements.get(0);
		elements.remove(0);
		return result;
	}
/**  finds size of queue
 * @return size of queue
 */
	@Override
	public int size() {
		int result=elements.size();
		return result;
	}
/**
 * adds to queue
 * @return true if enqueue is successful
 * @throws QueueOverflowException
 */
	@Override
	public boolean enqueue(Object e) throws QueueOverflowException {
		if (isFull()) 
			throw new QueueOverflowException();
		
		elements.add((T) e);
		return true;
		
		
	}
/**
 * string representation of queue
 * @return String separated by delimiter
 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (T ele:elements) {
			if(elements.indexOf(ele)==elements.size()-1)
				result+=ele;
			else
			result += ele + delimiter; // add elements separated by delimiter
			 
		}
		return result;
	}
	/**
	 *  string representation of queue
	 *  @return String representation of queue
	 */
	@Override
	public String toString() {
		String result = "";
		for (T ele:elements) {
				result+=ele;
		}
		return result;
	}

	
		
	}


