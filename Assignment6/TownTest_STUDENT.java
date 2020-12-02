import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownTest_STUDENT {
	Town town1, town2, town3, town4;

	@Before
	public void setUp() throws Exception {
		 town1 = new Town ("Town1");
		 town2 = new Town ("Town2");
		 town3 = new Town ("Town3");
		 town4 = new Town ("Town1");
	}
	
	@After
	public void tearDown() throws Exception {
		town1 = town2 = town3 = town4 = null;
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(town4.compareTo(town4) == 0);
		assertTrue(town1.compareTo(town2) < 0);
		assertTrue(town2.compareTo(town3) < 0);
		assertTrue(town4.compareTo(town1) == 0);
	}
	
	@Test
	public void testEquals() {
		assertTrue(town1.equals(town4));
		assertFalse(town2.equals(town3));
	}
	
	@Test
	public void testGetName() {
		assertEquals("Town1", town1.getName());
		assertEquals("Town2", town2.getName());
		assertEquals("Town3", town3.getName());
		assertEquals("Town1", town4.getName());
	}
	
	@Test
	public void testSetLastTown() {
		town1.setPrevious(town3);
		town2.setPrevious(town3);
		town3.setPrevious(town1);
		assertEquals(town3, town2.getPrevious());
		assertEquals(town1, town3.getPrevious());
		assertEquals(town3, town1.getPrevious());
	}
	
	@Test
	public void testToString() {
		assertEquals("Town1", town1.toString());
		assertEquals("Town3", town3.toString());
		assertEquals("Town1", town4.toString());
		assertEquals("Town2", town2.toString());
	}
}