import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	
	//GradeBook g1;
//	GradeBook gb1;
//	GradeBook gb2;
	GradeBook gb1 = new GradeBook(3);
	
	GradeBook gb2 = new GradeBook(3);
	
	
	@Before
	public void setUp() throws Exception{
		
		gb1.addScore(15);
		gb1.addScore(10);
		gb2.addScore(10);
		gb2.addScore(25);
		
		
	}
	
	@After
	public  void tearDown() throws Exception{
		gb1=null;
		gb2=null;
		
	}

	@Test
	public void testSum() {
		
		assertEquals(25,gb1.sum(),.0001);
		assertEquals(35,gb2.sum(),.0001);
	}

	@Test
	public void testMinimum() {
		assertEquals(gb1.minimum(),10);
		assertEquals(gb2.minimum(),10);
	}
	
	@Test
	public void testAddScore() {
		gb1.addScore(5);
		assertEquals(gb1.toString(), "15.0 10.0 5.0 ");
		assertEquals(gb1.getScoresSize(),3);
		gb2.addScore(45);
		assertEquals(gb2.toString(),"10.0 25.0 45.0 ");
		assertEquals(gb2.getScoresSize(),3);
	}

	@Test
	public void testFinalScore() {
		gb1.addScore(22);
		gb2.addScore(22);
		assertEquals(gb1.finalScore(),37);
		assertEquals(gb2.finalScore(),47);
	}

	@Test
	public void testGetScoreSize() {
		assertEquals(gb1.getScoresSize(),2);
		assertEquals(gb2.getScoresSize(),2);
	}

	@Test
	public void testToString() {
		gb1.addScore(83.4);
		gb2.addScore(98.8);
		assertEquals(gb1.toString(), "15.0 10.0 83.4 ");
		assertEquals(gb2.toString(),"10.0 25.0 98.8 ");
	}

}
