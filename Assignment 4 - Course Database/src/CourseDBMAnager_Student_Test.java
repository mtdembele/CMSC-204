import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class CourseDBMAnager_Student_Test {
	
	
	
	CourseDBManager dbm;

	@Before
	public void setUp() throws Exception {
		
		dbm = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dbm = null;
	}
	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dbm.add("CMSC207",30362,4,"SC440","Mikolaj Roman");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
		assertEquals(dbm.showAll().get(0),"\nCourse:CMSC207 CRN:30362 Credits:4 Instructor:Mikolaj Roman Room:SC440" );
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dbm.add("CMSC203",30504,4,"SC450","Annika Love");
		dbm.add("CMSC203",30503,4,"SC350","Georgina Fulton");
		dbm.add("CMSC204",30559,4,"SC450","BillyBob Jones");
		
		ArrayList<String> list = dbm.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:30503 Credits:4 Instructor:Georgina Fulton Room:SC350");
		assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30504 Credits:4 Instructor:Annika Love Room:SC450");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:30559 Credits:4 Instructor:BillyBob Jones Room:SC450");
		dbm.add("CMSC207",30362,4,"SC440","Mikolaj Roman");
		list = dbm.showAll();
		assertEquals(list.get(3),"\nCourse:CMSC207 CRN:30362 Credits:4 Instructor:Mikolaj Roman Room:SC440");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30504 4 SC450 Joey Bag-O-Donuts");
			inFile.println("CMSC203 30503 4 SC450 Jill B. Who-Dunit");
			inFile.println("CMSC204 30362 4 SC440 Mikolaj Roman");
			
			inFile.close();
			dbm.readFile(inputFile);
			//System.out.println(dbm.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception " + e);
		}
		boolean empty=true;
		for (int i=0;i<15;i++) {
			if (dbm.dbs.hashTable[i]!=null)
				empty=false;
			
		}
		
		assertEquals(true, empty);
	}
}

