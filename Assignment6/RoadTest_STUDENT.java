import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RoadTest_STUDENT {
	Road road1, road2, road3, road4;
	Town town1, town2,town3;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("Town 1");
		town2 = new Town("Town 2");
	    town3 = new Town("Town 3");
		road1 = new Road(town1, town2, 5, "Road 1");
		road2 = new Road(town2, town3, 6, "Road 2");
		road3 = new Road(town3, town1, 7, "Road 3");
		road4 = new Road(town2, town1, 5, "Road 1");
	}
	
	@After
	public void tearDown() throws Exception {
		road1 = road2 = road3 = road4 = null;
	}//	town1 = town2 =town3 =null;
	
	@Test
	public void testCompareTo() {
		assertTrue(road1.compareTo(road2) < 0);
		assertTrue(road3.compareTo(road4) < 0);
		assertTrue(road2.compareTo(road3) < 0);
		assertTrue(road4.compareTo(road1) == 0);
	}
	
	@Test
	public void testContains() {
		assertTrue(road1.contains(town2));
		assertTrue(road2.contains(town3));
		assertFalse(road3.contains(town2));

	}
	
	@Test
	public void testEquals() {
		assertFalse(road1.equals(road3));
		assertFalse(road2.equals(road4));
		assertTrue(road1.equals(road4));

	}
	
	@Test
	public void testGetDestination() {
		assertEquals(town2, road1.getDestination());
		assertEquals(town3, road2.getDestination());
		assertEquals(town1, road4.getDestination());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Road 1", road1.getName());
		assertEquals("Road 2", road2.getName());
		assertEquals("Road 3", road3.getName());
		assertEquals("Road 1", road4.getName());
	}
	
	@Test
	public void testGetSource() {
		assertEquals(town1, road1.getSource());
		assertEquals(town2, road2.getSource());
		assertEquals(town3, road3.getSource());
		assertEquals(town2, road4.getSource());
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(5, road1.getWeight());
		assertEquals(6, road2.getWeight());
		assertEquals(7, road3.getWeight());
		assertEquals(5, road4.getWeight());
	}
	
	@Test
	public void setDestination() {
		road1.setDestination(town3);
		road2.setDestination(town1);
		road4.setDestination(town2);
		assertEquals(town3, road1.getDestination());
		assertEquals(town1, road2.getDestination());
		assertEquals(town2, road4.getDestination());
	}
	
	@Test
	public void setName() {
		road2.setName("Road 12");
		road3.setName("Road 13");
		road4.setName("Road 14");
		assertEquals("Road 12", road2.getName());
		assertEquals("Road 13", road3.getName());
		assertEquals("Road 14", road4.getName());
	}
	
	@Test
	public void setSource() {
		road1.setSource(town3);
		road3.setSource(town2);
		assertEquals(town3, road1.getSource());
		assertEquals(town2, road3.getSource());
	}
	
	@Test
	public void setWeight() {
		road1.setWeight(100);
		road2.setWeight(200);
		road3.setWeight(300);
		assertEquals(100, road1.getWeight());
		assertEquals(200, road2.getWeight());
		assertEquals(300, road3.getWeight());
	}
	
	@Test
	public void testToString() {
		assertEquals("Road 1", road1.toString());
		assertEquals("Road 2", road2.toString());
		assertEquals("Road 3", road3.toString());
		
	}
}