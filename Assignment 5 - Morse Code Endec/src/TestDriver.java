import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TestDriver {
	public static void main(String[]args) {
		 MorseCodeTree<String> mt = new MorseCodeTree<String>();
		 ArrayList <String> a = new ArrayList<String>();
		 mt.buildTree(); // builds tree
		mt.LNRoutputTraversal(mt.getRoot(),a); // takes all letters in tree and adds to arrayList
		for(String s: a) { //print all letters
		 System.out.print(s+ " ");
		}
		 String code=".-"; // test ('a') 
		 /*char[] ca = code.toCharArray();
		 TreeNode<String> current = mt.getRoot();
		 System.out.println("\n"+current.getData());
		 for (int i=0;i<2;i++) {
			 if (code.charAt(i)=='.') {
				 current= current.left;
				 
			 }
			 else if (code.charAt(i)=='-') {
				 current= current.right;
				 
			 }
		 System.out.println(current.getData());
		 

		}*/
		 System.out.println("\nFinal: " +MorseCodeConverter.decode( code));
		 System.out.print("\n\n");
		 a=mt.toArrayList();
		 for (int i=0;i<a.size();i++) {
			 System.out.print(a.get(i));
		 }

	
	}
}
