/**
 * 
 * @author Mohammad Dembele
 *
 * @param <T>
 */
public class TreeNode<T> {
	 T data;
	 TreeNode left;
	 TreeNode right;
	/**
	 * tree node constructor w/ data
	 * @param dataNode
	 */
	public TreeNode(T dataNode){
		data = dataNode;
		left = right =null;
	}
	/**
	 * Constructor
	 * @param left
	 * @param right
	 * @param data
	 */
	TreeNode(TreeNode left, TreeNode right, T data){
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	/**
	 * deep copy 
	 * @param node
	 */
	public TreeNode(TreeNode<T> node){
		data=node.getData();
		left = new TreeNode<T>((T) node.left.getData());
		right = new TreeNode<T>((T) node.right.getData());
		 
	}
	/**
	 * 
	 * @return data
	 */
	public T getData() {
		return data;
	}
	/**
	 * 
	 * @param data
	 */
	public void setData(T data) {
		 this.data = data;
	}
	/**
	 * 
	 * @return left branch
	 */
	public TreeNode getLeft() {
		return left;
	}
	/**
	 * 
	 * @return right branch
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * 
	 * @param data
	 */
	public void setLeft(T data) {
		left = new TreeNode<T>(data);
	}
	/**
	 * initializes left
	 */
	public void newLeft() {
		left = new TreeNode<String>(null,null,null);
	}
	/**
	 * initializes right
	 */
	public void newRight() {
		right = new TreeNode<String>(null,null,null);
	}
	/**
	 * 
	 * @param data
	 */
	public void setRight(T data) {
		right = new TreeNode<T>(data);
	}
	/**
	 * 
	 * @param insertNode
	 */
	public void setRight(TreeNode insertNode) {
		right = insertNode;
		
	}
	/**
	 * 
	 * @param insertNode
	 */
	public void setLeft(TreeNode insertNode) {
		left = insertNode;
	}
}
