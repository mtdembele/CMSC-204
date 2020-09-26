
import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author MDembele
 * I went off the screenshot in the Assignment 1 handout 
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test LengthException
	 * Should not throw LengthException
	 */
	@Test
	public void testValidLengthValid()
	{
		
		try {
			PasswordCheckerUtility.isValidPassword("z4\\a*p");
		} catch(LengthException le) {
			fail("Incorrectly throws LengthException");
			
		} catch(Exception e) {
			
		}
		
		
		
	}
	
	/**
	 * Test LengthException
	 * Should throw LengthException
	 */
	@Test
	public void testInvalidLength()
	{
		/*
		try {
			PasswordCheckerUtility.isValidPassword("z4\\a*p");
		} catch(LengthException le) {
			
			
		} catch(Exception e) {
			
		}*/
		assertThrows(LengthException.class,() -> PasswordCheckerUtility.isValidPassword("za*p"));
	}
	/**
	 * Test NoUpperAlphaException
	 * Should not throw NoUpperAlphaException
	 */
	@Test
	public void testhasUpperAlpha()
	{
		try {
			PasswordCheckerUtility.isValidPassword("qt~WT2t@'Yw");
		} catch(NoUpperAlphaException e) {
			fail("Incorrectly throws NoUpperAlphaException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}
		
	}
	
	/**
	 * Test NoUpperAlphaException
	 * Should throw NoUpperAlphaException
	 */
	@Test
	public void testDoesNotHaveUpperAlpha()
	{
		assertThrows(NoUpperAlphaException.class, ()-> PasswordCheckerUtility.isValidPassword("qt~wt2t@'yw"));
	}
	
	/**
	 * Test NoLowerAlphaException
	 * SHould not throw NoLowerAlphaException
	 */
	@Test
	public void testHasLower()
	{
		try {
			PasswordCheckerUtility.isValidPassword("q~$H9M's>xD");
		} catch(NoLowerAlphaException e) {
			fail("Incorrectly throws NoLowerAlphaException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}
	}
	
	/**
	 * Test NoLowerAlphaException
	 * SHould throw NoLowerAlphaException
	 */
	@Test
	public void testNoLower()
	{/*
		try {
			PasswordCheckerUtility.isValidPassword("q~$H9M's>xD");
		} catch(NoLowerAlphaException e) {
			fail("Incorrectly throws NoLowerAlphaException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}*/
		assertThrows(NoLowerAlphaException.class, ()-> PasswordCheckerUtility.isValidPassword("QQ~WT2T@'YW"));
	}
	
	/**
	 * Test NoDigitException
	 * Should not throw NoDigitException
	 */
	@Test
	public void testHasDigit() {
		try {
			PasswordCheckerUtility.isValidPassword("g%86sxg,Z<x");
		} catch(NoDigitException e) {
			fail("Incorrectly throws NoDigitException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}
	}
	/**
	 * Test NoDigitException
	 * Should throw NoDigitException
	 */
	@Test
	public void testNoDigit()
	{
		assertThrows(NoDigitException.class, ()-> PasswordCheckerUtility.isValidPassword("qt~wQt@'yw"));
	}
	/**
	 * Test NoSpecialCharacterException
	 * Should not throw NoSpecialCharacterException
	 */
	@Test
	public void testHasSpecial()
	{
		try {
			PasswordCheckerUtility.isValidPassword("ZEPN5%Lz'.,");
		} catch(NoDigitException e) {
			fail("Incorrectly throws NoSpecialCharacterException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}
	}
	/**
	 * Test NoSpecialCharacterException
	 * Should throw NoSpecialCharacterException
	 */
	@Test
	public void testNoSpecial()
	{
		assertThrows(NoSpecialCharacterException.class, ()-> PasswordCheckerUtility.isValidPassword("qtcWt2tPqyw"));
	}
	@Test
	public void testHasSameChar()
	{
		try {
			PasswordCheckerUtility.isValidPassword("ZEPN5%Lz'.,");
		} catch(NoDigitException e) {
			fail("Incorrectly throws NoSpecialCharacterException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}
	}
	/**
	 * Test InvalidSequenceExcpetion
	 * Should not throw Invalid SequenceException
	 */
	@Test
	public void testHasNoInvalidSequence() 
	{
		try {
			PasswordCheckerUtility.isValidPassword("QWerty*2527");
		} catch(NoDigitException e) {
			fail("Incorrectly throws NoSpecialCharacterException");
			
		} catch(Exception e) {
			System.out.println("throws some other exception");
		}
	}
	/**
	 * Test InvalidSequenceExcpetion
	 * Should throw Invalid SequenceException
	 */
	@Test
	public void testHasInvalidSquence()
	{
		assertThrows(InvalidSequenceException.class, ()-> PasswordCheckerUtility.isValidPassword("qqqtcWt2t*Pqyw"));
	}
	/**
	 * Test isWeakPassword(String)
	 * first should be weak and second should not be weak
	 */
	@Test
	public void testBetweenSixandNineChars()
	{
		assertTrue(PasswordCheckerUtility.isWeakPassword("Qwer*1" ));
		assertEquals(PasswordCheckerUtility.isWeakPassword("QchSwer*1325)" ),false);
	}
	/**
	 * Test getInvalid(ArrayList)
	 * should return an arraylist that contains index 1, 3, 5 of testInval
	 */
	@Test
	public void testGetInvalid()
	{
		ArrayList<String> testInval = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		testInval.add("d]qv\\dT2,7`");
		testInval.add(":5fc_/7$f;8");	//Upper exception
		testInval.add("$W]q2cEfwKU");
		testInval.add("EdFPiiMxdlP!"); //digit exception
		testInval.add("6!D<tKyg*@W");
		testInval.add("7~2%7*4HP^*"); // lower exception
		
		result =PasswordCheckerUtility.getInvalidPasswords(testInval);
		assertTrue(result.get(0).contains(":5fc_/7$f;8"));
		assertTrue(result.get(0).toLowerCase().contains("upper"));
		
		assertTrue(result.get(1).contains("EdFPiiMxdlP!"));
		assertTrue(result.get(1).toLowerCase().contains("digit"));
		
		assertTrue(result.get(2).contains("7~2%7*4HP^*"));
		assertTrue(result.get(2).toLowerCase().contains("lower"));
		
		
			
	}
	/** 
	 * Not sure what to test so I tested getInvalid in the opposite way
	 * the arraylist returned by getInvalid should not contain index 0,2,4 of testInval
	 */
	@Test
	public void testGetValid()
	{
		ArrayList<String> testInval = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		testInval.add("d]qv\\dT2,7`");	//valid
		testInval.add(":5fc_/7$f;8");	//Upper exception
		testInval.add("$W]q2cEfwKU");	//valid
		testInval.add("EdFPiiMxdlP!"); //digit exception
		testInval.add("6!D<tKyg*@W");	//valid
		testInval.add("7~2%7*4HP^*"); // lower exception
		
		result =PasswordCheckerUtility.getInvalidPasswords(testInval);
		
		for (String s:result) {
			if (s.equals("d]qv\\dT2,7`") || s.equals("$W]q2cEfwKU") || s.equals("7~2%7*4HP^*")) {
				fail();
			}
		}
	}
}