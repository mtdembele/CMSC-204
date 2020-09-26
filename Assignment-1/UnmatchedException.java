/**
 * 
 * @author MDembele
 *
 */
public class UnmatchedException extends Exception {
 
	public UnmatchedException() {
		super();
		// TODO Auto-generated constructor stub
	}


	private static final String message = "The passwords do not match .";
	/**
	  * @returns message
	  */
	public String getMessage() {
		return message;
	}
	
}
