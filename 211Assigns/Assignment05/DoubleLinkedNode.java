/**
 * @(#)DoubleLinkedNode.java
 * @author Joseph L. Tapang
 * @version 1.00 2013/11/10
 */
public class DoubleLinkedNode<E>{
	private E data;
	
	private DoubleLinkedNode<E> next;
	
	private DoubleLinkedNode<E> prev;
	
	
	public DoubleLinkedNode(E data, DoubleLinkedNode<E> next, DoubleLinkedNode<E> prev){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	/**
	 * Used to construct a node that points to null for its prev and next.
	 * @param data Data is a generic variable to be stored in the node.
	 */
	public DoubleLinkedNode(E data){
		this(data, null, null);
	} 
	

	//getters
	public E getData(){
		return data;
	}
	
	public DoubleLinkedNode<E> getNext(){
		return next;
	}
	
	public DoubleLinkedNode<E> getPrev(){
		return prev;
	}
	//setters
	public void setData(E data){
		this.data = data;
	}
	
	public void setNext(DoubleLinkedNode<E> next){
		this.next = next;
	}
	
	public void setPrev(DoubleLinkedNode<E> prev){
		this.prev = prev;
	}
	
	@Override public String toString(){
		if(data == null){
			return null;
		}
		else{
			return data.toString();
		}
	}

}
