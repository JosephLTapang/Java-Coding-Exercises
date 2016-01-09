/**
 *@(#)OrderedLinkedList.java
 *@author Joseph L. Tapang
 *@version 1.00 2013/9/27(revision date: 2013/12/13)
 */


public class OrderedLinkedList<E>{

	private int size;

	private int index;

	private KeyedNode currentNode;

	private KeyedNode previousNode;

	private KeyedNode head;
	/**
	 * Constructor that creates the head node that points to null and initializes size to 0.
	 */
	public OrderedLinkedList(){
		head = null;
		this.size = 0;
	}
	/**
	 * Method returns the size of the list. 
	 * @return Returns the class variable size.
	 */
	public int size(){	  
		return this.size;
	}
	/**
	 * Adds to the list in alphabetical order or replaces a duplicate node.
	 * @param key The key to be compared with the currentNode's key.
	 * @param value The value of the new node to be inserted.
	 * @return Returns null if the node to be inserted did not have a duplicate or the old value of the node that was replaced.
	 */
	public E add(String key, E value){//still need to check duplicates, and correct adding to the front
		if(currentNode == null){
			currentNode  = new KeyedNode(key, value);
			head = currentNode;
		}
		else{
			if(key.compareToIgnoreCase(currentNode.getKey()) < 0){//add to left
				KeyedNode newNode = new KeyedNode(key, value);
				if(previousNode == null){
					previousNode = currentNode;
					newNode.setNext(currentNode);
					currentNode = newNode;
					head = currentNode;
				}
				else{	
					newNode.setNext(currentNode);
					previousNode = currentNode;
					currentNode = newNode;		
				}
			}
			else if(key.compareToIgnoreCase(currentNode.getKey()) > 0){//add to right
				KeyedNode newNode = new KeyedNode(key, value);	
				previousNode = currentNode;
				currentNode = newNode;
				currentNode.setNext(previousNode.getNext());
				previousNode.setNext(currentNode);
			}
		}
		size++;
		return null;
	}
	/**
	 * Method that looks through the keys of the OrderedLinkedList nodes and returns the data of the node.
	 * @param key The String key parameter used to search the OrderedLinkedList.
	 * @return Returns the data of the node with the matching key.
	 */
	public E find(String key){
		KeyedNode current = head;
		while(current != null){
			if(current.getKey().compareToIgnoreCase(key) == 0){
				return current.getData();
			}
			else if(key.compareToIgnoreCase(current.getKey()) < 0){
				return null;
			}
			else{
				current = current.getNext();
			}
		}
		return null;
	}
	/**
	 * Method that creates an index for the OrderedLinkedList, then uses the index to find the position of a node to return.
	 * @param position Position is an int variable used to match with index to find a node.
	 * @return Returns the data of the node in the desired position.
	 */
	public E get(int position){
		KeyedNode current = head;
		index = 0;
		if(position < 0 || position > size){
			return null;
		}
		while(current != null){
			if(index == position){
				return current.getData();
			}
			else{
				current = current.getNext();
				index++;
			}
		}
		return null;
	}
	/**
	 * Private inner class  KeyedNode of OrderedLinkedList begins.   
	 */
	private class KeyedNode{

		private String key;

		private E data;

		private KeyedNode next;

		public  KeyedNode(String keyWord, E dataItem){
			data = dataItem;
			key = keyWord;
			next = null;
		}
		//getters
		public E getData(){
			return data;
		}
		public KeyedNode getNext(){
			return next;
		}
		public String getKey(){
			return key;
		}
		//setters
		@SuppressWarnings("unused")
		public void setData(E nodeData){
			data = nodeData;
		}
		public void setNext(KeyedNode nodeNext){
			next = nodeNext;
		}
		@Override
		public String toString(){
			return "The nodes key is: " + key;
		}
	}
	/**
	 * private class KeyedNode ends   
	 */
}