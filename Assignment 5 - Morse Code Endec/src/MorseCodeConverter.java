import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	static int iChar=0;
	
	MorseCodeConverter(){
		
	}
	/**
	 * Converts code to english. Takes in full code, splits into letters, calls private decode() to decode induvidual letters
	 * @param code to be decoded
	 * @return  decoded morse code
	 */
	public static String convertToEnglish(String code) {
		MorseCodeTree<String> mt = new MorseCodeTree<String>();
		//mt.buildTree();
		String []codes = code.split(" ");
		String decoded="";
		for (String s : codes) {
			
			if (s == "/")
				decoded += " ";
			else 
				decoded +=(decode(s));
		}
		return decoded;
		
	}
	/**
	 * converts code to english
	 * @param codeFile file for input
	 * @return  decoded morse code
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String code ="";
		Scanner scan = new Scanner(codeFile);
		while (scan.hasNextLine()) {
			code +=scan.nextLine();
		}
		return convertToEnglish(code);
		
	}
		/**
		 * Decodes induvidual letters
		 * @param code morse code representaiton of a letter
		 * @return fetch(code) letter representation
		 */
		private static String decode(String code){
			MorseCodeTree<String> mt = new MorseCodeTree<String>();
		//	mt.buildTree();
			TreeNode current = mt.getRoot();
			return mt.fetch(code);
			
	}
	/**
	 *Turns tree into string via LNR traversal
	 * @return String representation of entire tree
	 */
	public static String printTree() {
		 String print =" ";
		 MorseCodeTree<String> mt = new MorseCodeTree<String>();
		 ArrayList <String> a = new ArrayList<String>();
	//	 mt.buildTree(); // builds tree
		mt.LNRoutputTraversal(mt.getRoot(),a); // takes all letters in tree and adds to arrayList
		for(String s: a) { //print all letters
		 print+=s + " ";
		}
		return print;
	}
	
	 
}
