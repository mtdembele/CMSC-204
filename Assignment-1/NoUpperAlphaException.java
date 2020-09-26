
/**
 * 
 * @author MDembele
 *
 */
public class NoUpperAlphaException extends Exception{
	

public NoUpperAlphaException() {
		super();
		// TODO Auto-generated constructor stub
	}

private static final String message= "The password must contain at least one uppercase alphabetic character.";
 
/**
 * @returns message
 */
	public String getMessage() {
		return message;
	}

}
