import java.util.Comparator;
import java.util.ListIterator;


/**
 * 
 * @author Mohammad Demebele
 *
 * @param <T> 
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	
	Comparator<T> compare;

	public SortedDoubleLinkedList(Comparator<T> comp) {
	super();
	this.compare=comp;
}
	@Override
	public ListIterator<T> iterator() { 
        return new MyIterator<T>(this); 
    } 
	/**Add new node with data to Sorted LL
	 * 
	 * @param data
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node node = new Node(data);
		 if(isEmpty()) {
	            head = node;
	            tail = node;
	            currentSize++;
	            
	        }
		current=head;
		while(current != null && compare.compare((T) current.data, data) < 0) { //if current data is smaller than data, move to next node
            current= current.next;
        } if (current==null) { //if there is no node.data>data, add to end
        	 tail.next = node;
             node.previous = tail;
             tail = node;
        }
        else if(current.previous==null) { // if current is head
			 node.next = head;
	          head.previous = node;
	          head = node;
		} else {
			current.previous.next=node;
			node.previous=current.previous;
			current.previous=node;
			node.next=current;
		}
		currentSize++;
		return this;
		} 

			
	
	/**
	 * @return 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T d) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	/**
	 * @return 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T d) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**see superclass
	 * 
	 * @return superclass remove
	 */
	@Override
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T> comp) {
		return (SortedDoubleLinkedList<T>) super.remove(targetData, comp );
	}
	
	
	
	
	

}
