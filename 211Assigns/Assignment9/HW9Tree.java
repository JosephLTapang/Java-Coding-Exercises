/**
 * @(#)HW9Tree.java
 * @ author Joseph L Tapang
 * @ Java version 1.00 11/08/13
 */
import java.util.LinkedList;
import java.util.List;

public class HW9Tree<E> {
	
	private BinaryNode<E> root;

	public HW9Tree(){
		root = null;
		//empty tree
	}
	/**
	 * This add method calls the private recursive method below it.
	 * @param item The item to be added to the tree.
	 * @param left The array of booleans which determines the direction the tree is reversed.
	 * @return Returns true if the add is successful.
	 */
	public boolean add(E item, boolean [] left){// if boolean array is too short, throw ArrayIndexOutofBoundsException
		add(root, item, left, 0);
		return true;
	}
	/**
	 * The private recursive method which may throw an exception if the boolean array that is passed is too short.
	 * @param currNode The current node that is being manipulated in the tree.
	 * @param item The item that is contained within the node. 
	 * @param left The array of booleans that determine the direction of travel through the tree.
	 * @param index Represents the index for the boolean array.
	 * @return Returns currNode.
	 */
	private BinaryNode<E> add(BinaryNode<E> currNode, E item, boolean [] left, int index){
		if(currNode != null && index >= left.length){
			throw new ArrayIndexOutOfBoundsException("The array is too small");
		}
		if(currNode == null){//if tree is empty			
			currNode = new BinaryNode<E>(item);
			if(root == null){
				root = currNode;
			}
			return currNode;
		}
		if(left[index]){
			currNode.left = add(currNode.left, item, left, index + 1);
			return currNode;
		}
		else{
			currNode.right = add(currNode.right, item, left, index + 1);
			return currNode; 
		}
	}
	/**
	 * The helper method that calls on the private recursive method.
	 * @return Returns a list.
	 */
	public List<E> toList(){
		return toList(root, new LinkedList<E>());
	}
	/**
	 * The private recursive method which performs an in-order traversal and adds to a list.
	 * @param node The node in the tree that is either traversed or added.
	 * @param list The list to which the nodes will be added in-order.
	 * @return Returns the list which is either complete or empty.
	 */
	private List<E> toList(BinaryNode<E> node, List<E> list){
		if(node == null){
			return list;
		}	
		toList(node.left, list);
		list.add(node.item);
		toList(node.right, list);	
		return list;
	}
	/**
	 * Helper method that calls the private recursive toString method.
	 */
	@Override
	public String toString(){ //if not maybe use arrayList to allow you to use the  
		return toString(root, 0);
	}
	/**
	 * The private recursive method which recursively adds spaces to a string and returning a family tree like result.
	 * @param node The node in the binary tree to be manipulated.
	 * @param depth The current depth of the tree.
	 * @return Returns the desired string representation of the tree.
	 */
	private String toString(BinaryNode<E> node, int depth){
		if(node == null){	
			return "";
		}
		String string = new String(); 
		for(int i = 0; i < depth*4; i++){
			string += " ";
		}	
		return string + node.item + "\n" + toString(node.left, depth + 1) + toString(node.right, depth + 1);
	}
	
	/**
	 *BinaryNode inner node class begins
	 */
	private static class BinaryNode<E> {
		private E item;
		private BinaryNode<E> left;
		private BinaryNode<E> right;
		/** 
		 * constructor to build a node with no subtrees
		 * @param the value to be stored by this node
		 */
		private BinaryNode(E value) {
			item = value;
			left = null;
			right = null;
		}
		/** 
		 * constructor to build a node with a specified (perhaps null) subtrees
		 * @param the value to be stored by this node
		 * @param the left subtree for this node
		 * @param the right subtree for this node
		 */
		private BinaryNode(E value, BinaryNode<E> l, BinaryNode<E> r) {
			item = value;
			left = l;
			right = r;
		}
	}
	/**
	 *BinaryNode inner class ends
     */
	
	public static void main(String [] args){//test area
		boolean [] lefts = {false, true, false};
		HW9Tree<String> myTree = new HW9Tree<String>();

		myTree.add("hello", new boolean [] {true});
		myTree.add("foo" , new boolean [] {true});
		myTree.add("bar" , new boolean [] {false});
		myTree.add("world" , new boolean [] {true, true});
		myTree.add("baz" , new boolean [] {true, false});
		myTree.add("bug" , new boolean [] {false, true});
		myTree.add("loop" , new boolean [] {false, false});
		myTree.add("fum", lefts);
		
		System.out.println(myTree.toList());
		
		System.out.println(myTree.toString());
	}
}
