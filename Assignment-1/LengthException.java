/**
 * 
 * @author MDembele
 *
 */
public class LengthException extends Exception{

	public LengthException() {
		super();
		// TODO Auto-generated constructor stub
	}


	private static final String message = "The password must be at least 6 characters long." ;
	/**
	  * @returns message
	  */
	public  String getMessage() {
		return message;
	}
}
