/**
 * @(#)LinkedQueue.java
 * @author Joseph L. Tapang
 * @version 1.00 2013/25/10
 * 
 */

public class LinkedQueue<E> {

	private Node<E> head;

	private int size;

	public LinkedQueue(){
		head = null;
		size = 0;
	}
	/**
	 * Method that offers a value to the Linked List based queue.
	 * @param value Value is the data stored in the new node to be inserted.
	 * @return Returns true if offer is successful or false if it is not.
	 */
	public boolean offer (E value){		
		Node <E> currNode = head;
		Node <E> newNode = new Node<E>(value);
		if(value == null){
			return false;
		}
		if(currNode == null){
			head = newNode;
			head.setNext(null);
			currNode = head;
			return true;
		}		
		if(currNode != null && currNode.getData().equals(value)){
			return false;
		}
		while(currNode.getNext() != null){
			currNode = currNode.getNext();
			if(value.equals(currNode.getData())){
				return false;
			}
		}
		currNode.setNext(newNode);
		newNode.setNext(null);
		size++;
		return true;		
	}
	/**
	 * Returns and removes the data from the queue.
	 * @return Returns the data of the temporary node named temp or null if head points to null.
	 */
	public E poll(){
		Node<E> temp;
		if(head == null){
			return null;
		}
		else{
			temp = head;
			head = head.getNext();			
			size--;
			return temp.getData();
		}
	}
	//Private Node class begins
	@SuppressWarnings("hiding")
	private class Node<E> {
		private E data;
		private Node<E> next;
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		public Node(E data) {
			this(data, null);
		}

		public E getData() {
			return data;
		}

		@SuppressWarnings("unused")
		public void setData(E data) {
			this.data = data;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}
	}
	//Private Node class ends
	public static void main(String[] args) {// Short Test
		LinkedQueue<String> newQueue = new LinkedQueue<String>();

		newQueue.offer("A");
		newQueue.offer("B");
		System.out.print(newQueue.poll());
		System.out.print(newQueue.poll());
		System.out.print(newQueue.poll());
	}
}
