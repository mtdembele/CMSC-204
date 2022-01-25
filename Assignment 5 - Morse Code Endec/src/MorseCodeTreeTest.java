
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Mohammad Dembele
 * JUnit tests for MorseCodeTree
 * There are no insert or add tests because if addnode works -> insert/insertNode works -> buildTree works, so buildTree test is sufficient
 *
 */
public class MorseCodeTreeTest {
	MorseCodeTree<String> testTree;
	
	@Before
	public void setUp() throws Exception {
	 testTree = new MorseCodeTree<String>();
	}

	@After
	public void tearDown() throws Exception {
		testTree=null;
	}


	@Test
	public void testFetch() {
		String code=".-";
		assertEquals("a",testTree.fetch(code));
	}

	@Test
	public void testDelete() {
		boolean thrown=false;
		try {
			testTree.delete("a");
		} catch(UnsupportedOperationException e) {
			thrown=true;
		}
		assertEquals(true,thrown);
	}

	@Test
	public void testUpdate() {
		boolean thrown=false;
		try {
			testTree.update();
		} catch(UnsupportedOperationException e) {
			thrown=true;
		}
		assertEquals(true,thrown);
	}

	@Test
	public void testBuildTree() {
		String correct = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		assertEquals(correct.trim(),MorseCodeConverter.printTree().trim());
	}

	@Test
	public void testToArrayList() {
		String [] correct = "h s v i f u e l r a p w j  b d x n c k y t z g q m o".split(" ");
		ArrayList <String> temp = new ArrayList<String>();
		for (String s:correct) {temp.add(s);}
		assertEquals(temp, testTree.toArrayList());
	}

	@Test
	public void testLNRoutputTraversal() {
		ArrayList <String> temp = new ArrayList<String>();
		testTree.LNRoutputTraversal(testTree.getRoot(),temp);	
		assertTrue(temp.equals(testTree.toArrayList()));
	}

}
