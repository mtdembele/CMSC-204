/**
 * 
 * @author MDembele
 *
 */
public class WeakPasswordException extends Exception{
	
	public WeakPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	
	}

	private static final String message = "The password is OK but weak - it contains fewer than 10 characters.";
	/**
	  * @returns message
	  */
	public String getMessage() {
		return message;
	}

}
