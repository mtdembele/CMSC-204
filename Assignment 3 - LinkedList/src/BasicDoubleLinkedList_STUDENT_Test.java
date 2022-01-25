import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;








public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<Integer> linkedInt;
	ArrayList<Integer> list;
	
	IntComparator comparator;
	
	@Before
	public void setUp() throws Exception {
		linkedInt= new BasicDoubleLinkedList<Integer>(); 
		linkedInt.addToEnd(12);
		linkedInt.addToEnd(13);
		comparator = new IntComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedInt=null;
	}
	@Test
	public void testToArrayList() throws UnsupportedOperationException
	{
		list = linkedInt.toArrayList();
		
		assertEquals(12,(int)list.get(0));
		assertEquals(13,(int)list.get(1));
		
	}
	@Test
	public void testIteratorSuccessfulNext() throws UnsupportedOperationException {
		ListIterator<Integer> iterator = linkedInt.iterator();
		assertEquals(12,(int)iterator.next());
	}
	@Test
	public void testIteratorSuccessfulPrevious() throws UnsupportedOperationException {
		ListIterator<Integer> iterator = linkedInt.iterator();
		iterator.next();
		assertEquals(12,(int)iterator.previous());
	}

	@Test
	public void testGetSize() {
		assertEquals(2,linkedInt.getSize());
	}
	@Test
	public void testGetFirst() throws UnsupportedOperationException {
	assertEquals(12,(int)linkedInt.getFirst());
	}
	@Test
	public void testGetLast() throws UnsupportedOperationException {
		assertEquals(13,(int)linkedInt.getLast());
	}
	@Test
	public void testAddToEnd() throws UnsupportedOperationException {
		linkedInt.addToEnd(5);
		assertEquals(5,(int)linkedInt.getLast());
	}
	@Test
	public void testAddToFront() throws UnsupportedOperationException {
		linkedInt.addToFront(2);
		assertEquals(2,(int)linkedInt.getFirst());
	}
	@Test
	public void testHasNext() {
		ListIterator<Integer> iterator = linkedInt.iterator();
		assertEquals(true,iterator.hasNext());
		
	}
	@Test
	public void testHasPrevious() {
		ListIterator<Integer> iterator = linkedInt.iterator();
		assertEquals(false,iterator.hasPrevious());
		iterator.next();
		iterator.next();
		assertEquals(true,iterator.hasPrevious());

	}

	
	class IntComparator implements Comparator{  
		public int compare(Object o1, Object o2){  
		 int s1=(int) o1;  
		 int s2=(int) o1;  
		  
		if(s1==s2)  
		return 0;  
		else if(s1>s2)  
		return 1;  
		else  
		return -1;  
		}

		
		}  
}
