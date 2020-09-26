/**
 * 
 * @author MDembele
 *
 */
public class NoDigitException extends Exception {

	public NoDigitException() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String message = "The password must contain at least one digit.";
	/**
	  * @returns message
	  */
	public String getMessage() {
		return message;
	}
}
