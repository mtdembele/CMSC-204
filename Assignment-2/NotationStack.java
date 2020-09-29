
import java.util.ArrayList;
/**
 * 
 * @author Mohammad Dembele
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface {

	private ArrayList<T> elements;
	private int maxSize=100;
	
	/**size constructor
	 * 
	 * @param size
	 */
	public NotationStack(int size){
		this.maxSize=size;
		elements = new ArrayList<T>(size);
		
	}
	/**
	 * default constructor
	 */
	public NotationStack() {
		this(100);
		
	}
	
/**copies an arraylist for stack
 * 
 * @param aList array to be copied
 */
	public NotationStack(ArrayList<T> aList) {
		this.elements=(ArrayList<T>) aList;
		
	}
/**
 * checks if stack is empty 
 * @return true if stack is empty, false if string is not empty
 */
	@Override
	public boolean isEmpty() {
		if (elements.size()==0) 
			return true;
		else 
			return false; 
	}
/**checks if stack is full
 * @return true if stack is full , false if stack is not full
 */
	@Override
	public boolean isFull() {
		if(elements.size()==maxSize)
			return true;
		else 
			return false;
	}
/** removes an object from the stack
 * @return the object that is removed
 * @throws StackUnderflowException
 */
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
/**
 * peeks top of stack\
 * @return the object at top of stack, does not remove 
 */
	@Override
	public Object top() throws StackUnderflowException {
		if(this.isEmpty()) {
			throw new StackUnderflowException();
		}else {
		
		return elements.get(elements.size()-1);
			}
	}
/**
 * checks size of stack
 * @return size of stack
 */
	@Override
	public int size() {
		return elements.size();
		
	}
/**adds object to stack
 * @return true if object is successfully added
 * @throws StackOverflowException
 */
	@Override
	public boolean push(Object e) throws StackOverflowException {
		if (this.isFull())
			throw new StackOverflowException();
		else
			elements.add((T) e);
		return true;
	}
/**
 * string representation of stack
 * @return String separated by delimiter
 */
	@Override
	public String toString(String delimiter) {
		String result = "";
		for (T ele:elements) {
			if(elements.indexOf(ele)==elements.size()-1)
				result+=ele;
			else
			result += ele + delimiter; // Separated by delimiter
			 
		}
		return result;
	}
	/**
	 *  string representation of queue
	 *  @return String representation of queue
	 */
	@Override
	public String toString() {
		String result="";
		for (T t:elements)
			result+=t;
		return result;
	}

}
