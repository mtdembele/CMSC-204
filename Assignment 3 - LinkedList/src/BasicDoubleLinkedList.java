import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Mohammad Dembele
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>  {
	 Node current;
	 Node head;
	 Node tail;
	 int currentSize;
	 public ListIterator<T> iterator() { 
	        return new MyIterator<T>(this); 
	    } 
	 
/**
 * 
 * @author Mohammad Dembele
 *
 * @param <T>
 */
	 	class MyIterator<T> implements ListIterator<T>{
	 		private Node curr;
	 		private Node prev;
	 		
	 		public MyIterator(BasicDoubleLinkedList<T> LL) {
	 			curr=LL.head; 
	 			
	 			prev=null;
	 		}

	 		/**
	 		 * @return true if there are more elements to iterate 
	 		 */
			@Override
			public boolean hasNext() {
				
				return curr!=null;
			}
			/**
			 * @return data in next node
			 */
			@Override
			public T next() throws NoSuchElementException {
				if(curr==null)
					throw new NoSuchElementException();
				prev=curr;
				T temp =(T) curr.data;
				curr=curr.next;
				return temp;
			}
			
			
			/**
			 * @return data in previous node
			 */
			@Override
			public T previous() throws NoSuchElementException{
				if(prev==null)
					throw new NoSuchElementException();
				T temp=(T) prev.data;
				curr=prev;
				prev=prev.previous;
				return (T) temp;
			}
			/**
			 * @return return true if there is a previou7a node
			 */
			@Override
			public boolean hasPrevious() {
				return prev!=null;
				
			}
			/**
			 * @throws UnsupportedOperationException
			 */
			@Override
			public int nextIndex() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
				
			}
			/**
			 * @throws UnsupportedOperationException
			 */
			@Override
			public int previousIndex() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}
			/**
			 * @throws UnsupportedOperationException
			 */
			@Override
			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}
			/**
			 * @throws UnsupportedOperationException
			 */
			@Override
			public void set(T e) throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}
			/**
			 * @throws UnsupportedOperationException
			 */
			@Override
			public void add(T e)  throws UnsupportedOperationException {
				throw new UnsupportedOperationException();
			}

	 	}
	 	/**
	 	 * 
	 	 * @author Mohammad Dembele
	 	 *
	 	 * @param <T>
	 	 */
		class Node<T> {
			T data;
			Node next;
			Node previous;
			
			/** 
			 * constructor w data
			 * @param d - data for new node
			 */
			Node(T d) {
				this.data=d;
				this.previous=this.next=null;
			}
			Node(){
				this.data=null;
				this.previous=this.next=null;
			}
		}
		
		
	/**
	 * default constructor
	 */
	public BasicDoubleLinkedList() {
		head=tail=null;
		currentSize=0;
		
	}
	/**
	 * 
	 * @return true if linked list is empty
	 */
	 public boolean isEmpty() {
	        return head == null;
	    }
	 /**
	  * adds an new node to end 
	  * @param d - data to be added to new node
	  * @throws UnsupportedOperationException
	  */
	public BasicDoubleLinkedList<T> addToEnd(T d) throws UnsupportedOperationException {
		Node node = new Node(d);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
        currentSize++;
		return this;
    }
	/**
	 * adds data to front of Linked List
	 * @param d - data to be added to front
	 * @throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToFront(T d) throws UnsupportedOperationException  {
		Node node = new Node(d);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
        currentSize++;
        return this;
    }
	/**returns data in head node
	 * 
	 * @return data in head node
	 */
	public T getFirst() {
		if(isEmpty())
			return null;
		else
		return (T) head.data;
	}
	/**
	 * return data in tail node
	 * @return data in tail node
	 */
	public T getLast() {
		if (isEmpty()) 
			return null;
		else
			return (T) tail.data;
	}
	/**returns number of elements
	 * 
	 * @return number of elements
	 */
	public int getSize() {
		return currentSize;
	}
	/**removes first instance of targetdata
	 * 
	 * @param targetData
	 * @param comparator 
	 * @return reference to List
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator)  {
		if (isEmpty()) {
            return this;
        }

        // find the position of the key
         current = head;

        while(current != null && comparator.compare((T) current.data, targetData) != 0) {
            current= current.next;
        }

        if(current == null) {
            System.out.print("not found");
            return null;
        }

        // if current is head, delete the head
        if (current.previous == null) {
        	retrieveFirstElement();
        	return this;

        } else if (current.next == null) { // if current is last item
        	retrieveLastElement();
        	return this;

        } else { //anywhere between first and last node
        	Node previous = current.previous;
        	Node next = current.next;
            

            previous.next = next;
            next.previous = previous;

            current.previous = null;
            current.next = null;
            current = null;
        }   

        currentSize--;
        return this;
    }
	/**delete head and return data
	 * 
	 * @return data in head
	 */
	public T retrieveFirstElement() {
		if (isEmpty()) { // if(head=null)
            return null;
        }
        T temp = (T) head.data;
        Node next = head.next;
        if (next != null) { //if there is a next node
            next.previous = null; //deletes the head
        }
        head = next; //updating the head 
        currentSize--; //change size
        return temp;
        
    }
	
	/**delete tail , return its data
	 * 
	 * @return data in tail
	 */
	public T retrieveLastElement() {
		if (isEmpty()) { 
            return null;
        }
        T temp = (T) tail.data;
        Node prev = tail.previous;
        if (prev != null) { //if there is a previous node
            prev.next = null; // delete the 
        }
        tail.previous = null;
        tail = prev;
        currentSize--;
        return temp;
    }
	/**
	 * 
	 * @return ArrayList representation of data in LinkedList
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> temp = new ArrayList<T>(getSize());
		current = head;
		while(current!=null) {
			temp.add((T) current.data);
		current=current.next;
		}
		return temp;
	}


	
}
