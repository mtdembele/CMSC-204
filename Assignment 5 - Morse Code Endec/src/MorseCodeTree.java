import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author Mohammad Dembele
 * @param <T>
 *
 */
public class MorseCodeTree<T> implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root = new TreeNode<String>("");
	private int iFetch=0;
	private int iAdd=0;
	@Override
	/**
	 * @return reference to root
	 */
	public TreeNode<String> getRoot() {
		return (TreeNode<String>) root;
	}
	/**
	 * @param newNode
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = (TreeNode<String>) newNode;
	}
	/**
	 * constructor,calls buildtree()
	 */
	public MorseCodeTree() {
		buildTree();
	}
	/** calls private insertNode(recursive)
	 * @param Morse code, letter to be inserted
	 * @return reference to tree w/ inserted node
	 */
	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}
	/**recursive method to add Node to tree
	 * @param root, morsecode, letter to be inserted
	 * 
	 */
	@Override
	public void addNode(TreeNode<String> root, String code,String letter){
		if (iAdd==code.length()) {
			root.data=letter;
			iAdd=0;
		} else if(code.charAt(iAdd)=='.') {
			iAdd++;
			if (root.left==null)
				root.left= new TreeNode<String>(null,null,null);
			addNode(root.left,code,letter);
		} else {
			iAdd++;
			if (root.right==null)
				root.right= new TreeNode<String>(null,null,null);
			addNode(root.right,code,letter);
		}
		
	}
	/**finds letter based on morsecode
	 * @param morsecode
	 * @return letter corresponding to morsecode
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root,code);
	}
	/**@param root - the root of the tree for this recursive instance of addNode
	 *@param code - the code for this recursive instance of addNode
	 * @return letter corresponding to code '.' means left, '-' means right
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (iFetch==code.length()) {
			iFetch=0;
			return root.getData();
		} else if(code.charAt(iFetch)=='.') {
			iFetch++;
			return fetchNode(root.left,code);
		}else if(code.charAt(iFetch)=='/') {
			iFetch++;
			return " ";
		} else {
			iFetch++;
			return fetchNode(root.right,code);
		}
			
	}
	/**
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	/**inserts all letters into tree
	 * 
	 */
	@Override
	public void buildTree() {
		String codes[] = {
				".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
				};
		String letters[]= {"a",	"b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	for (int i=0;i<codes.length;i++) {
		insert(codes[i], letters[i]);
	}
	}
	/**@return Arraylist representation of LNR traversal
	 * 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> temp = new ArrayList<String>();
		LNRoutputTraversal(root,temp);
		
		
		return temp;
	}
	/**
	 * @param root the root for the current instance of traversal
	 * @param list list to receive Arraylist representation  
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root ==null)
			return;
		
		LNRoutputTraversal(root.getLeft(),list);
		list.add(root.getData());
		LNRoutputTraversal(root.getRight(),list);
	}
	
	private TreeNode<String> insertNode(TreeNode<String> currentParent, TreeNode<String> newNode, ArrayList<Character> codeList, Iterator myIt ){
		if (currentParent == null) {
	        return newNode;
	    } else if ((char)myIt.next()=='-') {
	    if (currentParent.getRight()==null) {
	    	currentParent.right = new TreeNode<String>(" ");
	    }
	        currentParent.setRight(insertNode(currentParent.getRight(), newNode,codeList,myIt));
	    } else if ((char)myIt.next()=='.') {
	    	if (currentParent.getLeft()==null) {
		    	currentParent.left = new TreeNode<String>(" ");
		    }
	        currentParent.setLeft(insertNode(currentParent.getLeft(), newNode,codeList,myIt));
	    }

	    return currentParent;
	}
	

}
