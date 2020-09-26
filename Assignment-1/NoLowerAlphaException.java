/**
 * 
 * @author MDembele
 *
 */
public class NoLowerAlphaException extends Exception{
	

	public NoLowerAlphaException() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final String message= "The password must contain at least one lowercase alphabetic character.";
	/**
	  * @returns message
	  */
	public String getMessage() {
		return message;
		
	}
}
