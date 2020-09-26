/**
 * @author MDembele
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordCheckerUtility {
	
	private static ArrayList <String> invalid =  new ArrayList<String>();
/**
 * checks validity of password
 * @param pass password
 * @return true if no exceptions are thrown
 * @throws LengthException >6
 * @throws NoDigitException no digit
 * @throws NoUpperAlphaException no uppercase
 * @throws NoLowerAlphaException no lowecase
 * @throws InvalidSequenceException same char 3+ times in a row
 * @throws NoSpecialCharacterException no special character
 */
	public static boolean isValidPassword(String pass) throws LengthException,NoDigitException,NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {
		//lengthexception
		if (pass.length()<6) {
			invalid.add(pass);
			
			throw new LengthException();
			
		} //NoLowerException
		if (pass == pass.toUpperCase()) { //doUBLE CHECK toUPPERcASE AND toLowercase to make sure they are not mixed up
			invalid.add(pass);
			throw new NoLowerAlphaException();
		} // NoUpperException
		if (pass == pass.toLowerCase()) {
			invalid.add(pass);
			throw new NoUpperAlphaException();
			
		}
		//NoDigitException
		boolean hasDigit=false;
		
		for (int i=0;i<pass.length();i++) { 
			if( (int) pass.charAt(i)>47 && (int)pass.charAt(i) <58 ) { //if ascii value is in number range
				hasDigit = true;										//***I THINK I CAN JUST THROW EXCEPTION ISTEAD OF BREAK;***
				break;
			}
		}
		if(!hasDigit) {
			invalid.add(pass);
			throw new NoDigitException();
		}
		//NoSpecialException
		
		boolean hasSpecial=false;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*"); 

		Matcher matcher = pattern.matcher(pass); 

		if (!matcher.matches()) {
	           hasSpecial=true;
	      }  /*
		for (int i=0;i<pass.length();i++) {
			if (!(pass.toLowerCase().charAt(i)>96 && pass.toLowerCase().charAt(i)<122) && //if ascii code isn't in range of lowecase 
					!(pass.toLowerCase().charAt(i)>47 && pass.toLowerCase().charAt(i)<58 )) { //or numbers
				hasSpecial=true;															//***I THINK I CAN JUST THROW EXCEPTION ISTEAD OF BREAK;***
				break;
			}
		} */
		if(!hasSpecial) {
			invalid.add(pass);
			throw new NoSpecialCharacterException();
		}
		
		//InvalidSequenceException
		for (int i=0;i<pass.length()-2;i++) { 
			for (int j=i+2;j<pass.length();j++) {
			if (pass.charAt(i) == pass.charAt(j) &&pass.charAt(i) == pass.charAt(i+1)) {
				invalid.add(pass);
				throw new InvalidSequenceException();
			}
			}
			
		}/* Don't throw WeakPass 
		if (pass.length()<10 && pass.length()>5) {
			throw new WeakPasswordException();
		}*/
	return true;

	}
	/**
	 * Checks if password is weak (length between 6 and 9)
	 * @param pass password being passed
	 * @return true if pass is weak
	 */
	public static boolean isWeakPassword(String pass) {
		if(pass.length()<=9)
			return true;
		else
			return false;
	}
	/**
	 * 
	 * @param arg ArrayList that will copy invalid passwords
	 * @return arraylist with invalid passwords and reasons
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> arg){
		
		ArrayList<String> copy = new ArrayList<String>();
			for(String s :arg ) {
				try {
					isValidPassword( s);
				} catch(Exception e) {
					copy.add(s + " -> " + e.getMessage() );
				}
			
			}
		
		
		
		return copy;
		
	}
	
	}


