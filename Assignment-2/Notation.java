
/**
 * 
 * @author Mohammad Dembele
 *
 */
public class Notation {

	
	/**
	 * default constructor
	 */
	public Notation() {
		 
	}
	/**
	 * Converts infix notation to postfix notation
	 * 
	 * @param infix - expression in infix notation
	 * @return result - expression in postfix notation
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix)throws InvalidNotationFormatException {
		//check if format if valid
		
		NotationQueue<Character> postQueue = new NotationQueue<Character>();
		NotationStack<Character> stack = new NotationStack<Character>();
		
		
		for (int i = 0; i<infix.length(); ++i) 
        { 
            char c = infix.charAt(i); 
              if(c==' ') //if it is space skip
            	  continue;
             //if c is digit
              else if (Character.isDigit(c)) 
            	postQueue.enqueue(c); 
               
            // If the char is '(', push onto to the stack. 
            else if (c == '(') 
                stack.push(c); 
            //  If the c = ')', pop and enqueue   until it finds ')'
            else if (c == ')') 
            { 
                while ((char)stack.top() != '(' && !stack.isEmpty()) 
                	postQueue.enqueue((char)stack.pop()); 
                  
                if (!stack.isEmpty() && (char)stack.top() != '(') 
                	throw new InvalidNotationFormatException(); // invalid expression                 
                else
                    stack.pop(); 
            } 
            else if (isOperator(c)) 
            { 
                while (!stack.isEmpty() && hasPrecedence(c) <= hasPrecedence((char)stack.top())){ 
                    if((char)stack.top() == '(') 
                        throw new InvalidNotationFormatException(); 
                    postQueue.enqueue((char)stack.pop()); 
             } 
                stack.push(c); 
            }}
        
       
        // pop everything else 
        while (!stack.isEmpty()){ 
            if((char)stack.top() == '(') 
            	throw new InvalidNotationFormatException();
            postQueue.enqueue((char)stack.pop()); 
         }
        
		String result=postQueue.toString();
		return result;
		
	}
	/**converts a string in postfix to infix
	 * 
	 * @param postfix - expression in postfix notation
	 * @return result - expression in infix notation
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		
		NotationStack<Character> stack = new NotationStack<Character>();
		
		
		for (int i = 0; i<postfix.length(); ++i) 
        { 
            char c = postfix.charAt(i); 
              if(c==' ') //if it is space skip
            	  continue;
             //if c is digit
              else if (Character.isDigit(c)) 
            	stack.push(c);
              else if (isOperator(c)) {
              if (stack.size()<2)
        		  throw new InvalidNotationFormatException();
              
              String pop1=String.valueOf(stack.pop());
              String pop2=String.valueOf(stack.pop());
              stack.push('(' + pop2 + c +pop1 + ')');
        }
        }
		if( stack.size()>1)
			throw new InvalidNotationFormatException();
		
		String result=stack.toString();
		
		return result;
	
	}
	/**
	 * evaluates an expression in postfix expression
	 * 
	 * @param postfix - expression in postfix notation
	 * @return result - solution to postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression(String postfix)throws InvalidNotationFormatException {
		NotationStack<Double> stack = new NotationStack<Double>();
		for (int i = 0; i<postfix.length(); ++i) 
        { 
            char c = postfix.charAt(i); 
              if(c==' ') //if it is space skip
            	  continue;
              else if (Character.isDigit(c))  // if it is a digit push onto stack
            	  stack.push(c);
              else if (isOperator(c)) { // if it is an operator
            	  if (stack.size()<2)		//if size<2 invalid format
            		  throw new InvalidNotationFormatException();
            	  	//pop 2 operands and evaluate expression
            	 double pop1=Double.parseDouble( String.valueOf(stack.pop()));
            	 double pop2=Double.parseDouble( String.valueOf(stack.pop()));
            	 switch(c) 
                 { 
                     case '+': 
                     stack.push(pop2+pop1); 
                     break; 
                       
                     case '-': 
                     stack.push(pop2- pop1); 
                     break; 
                       
                     case '/': 
                     stack.push(pop2/pop1); 
                     break; 
                       
                     case '*': 
                     stack.push(pop2*pop1); 
                     break; 
               } 
        }
              
        }
		double result= (double) stack.pop();
		return result;
	}
	/**checks if char is an operator (/,*,+,-)
	 * 
	 * @param c - char
	 * @return true if c is an operator, false if c is not at operator
	 */
	private static boolean isOperator(char c) {
		if ( c == '/' || c == '*' || c == '+' || c == '-')	
			return true;
			else return false;
	}
	/**checks the precedence of operators
	 * 
	 * @param c
	 * @return 1 if operator is +/-, 2 if *,/
	 */
	private static int hasPrecedence(char c) {
		{ // higher number = precedence over lower number can be used to compare 2 operators
	        switch (c) 
	        { 
	        case '+': 
	        case '-': 
	            return 1; 
	       
	        case '*': 
	        case '/': 
	            return 2; 
	        } 
	        return -1; 
	    }
}
}
