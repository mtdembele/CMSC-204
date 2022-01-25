import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SortedDoubleLinkedList_STUDENT_Test {

	SortedDoubleLinkedList<Integer> linkedInt;
	
	
	IntComparator comparator;
	
	@Before
	public void setUp() throws Exception {
		linkedInt= new SortedDoubleLinkedList<Integer>(comparator); 
		
		comparator = new IntComparator();
	}

	@After
	public void tearDown() throws Exception {
		linkedInt=null;
	}
	@Test public void testAdd() throws Exception{
		linkedInt = new SortedDoubleLinkedList<Integer>(comparator);
		linkedInt.add(1);
		linkedInt.add(2);
		assertEquals(1,(int)linkedInt.getFirst());
	}
	@Test public void testRemove() throws Exception{
		linkedInt = new SortedDoubleLinkedList<Integer>(comparator);
		linkedInt.add(13);
		linkedInt.add(12);
		linkedInt.remove(12, comparator);
		assertEquals(13,(int)linkedInt.getFirst());
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
