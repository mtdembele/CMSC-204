/**
 * 
 * @author MDembele
 *
 */
public class NoSpecialCharacterException extends Exception{

	public NoSpecialCharacterException() {
		super();
		// TODO Auto-generated constructor stub
	}


	private static String message = "The password must contain at least one special character.";
	/**
	  * @returns message
	  */
	public String getMessage() {
		return message;
	}
}
