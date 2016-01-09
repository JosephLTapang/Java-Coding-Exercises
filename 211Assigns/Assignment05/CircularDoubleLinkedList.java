/**
 * @(#)CircularDoubleLinkedList.java
 * @author Joseph L. Tapang
 * @version 1.00 2013/11/10
 */

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CircularDoubleLinkedList<E> implements Iterable<E>{
	
	private int size;	
	
	private DoubleLinkedNode<E> head;
	
	public CircularDoubleLinkedList(){
		this.head = null;
		size = 0;		
	}		
	/**
	 * Adds an item to the end of the list.
	 * 
	 * @param data The Data that is to be stored in the node.
	 */ 
	public void add(E data){	
		DoubleLinkedNode<E> newNode = new DoubleLinkedNode<E>(data);
		if(this.head == null){
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			this.head = newNode;
			size++;
			//if list is empty create a new node and insert
		}
		else{
			DoubleLinkedNode<E> temp = this.head.getPrev();
			this.head.getPrev().setNext(newNode);
			this.head.setPrev(newNode);
			newNode.setPrev(temp);
			newNode.setNext(this.head);		
			size++;
		}
	}
	/**
	 * Which adds an item at the specified index.
	 * 
	 * @param index The index in which the new Node is added. 
	 * @param data The data which is to be stored in the node.
	 */
	public void add(int index, E data){
		int currIndex = 0;
		DoubleLinkedNode<E> currNode = this.head;
		DoubleLinkedNode<E> nextNode = this.head.getNext();
		DoubleLinkedNode<E> prevNode = this.head.getPrev();
		DoubleLinkedNode<E> newNode = new DoubleLinkedNode<E>(data);
		if(index == 0){
			prevNode.setNext(newNode);
			currNode.setPrev(newNode);
			newNode.setPrev(prevNode);
			newNode.setNext(currNode);
			this.head = newNode;
			size++;	
		}
		else if (index > 0){		
			while(currIndex != size){
				if(currIndex != index%size){
					currIndex++;
					currNode = currNode.getNext();
					nextNode = nextNode.getNext();
					prevNode = prevNode.getNext();					
				}else{				
					newNode.setPrev(prevNode);
					newNode.setNext(currNode);
					prevNode.setNext(newNode);
					currNode.setPrev(newNode);
					currNode = newNode;
					size++;
					break;										
				}
			}		
		}
		else if (index < 0){
			while(currIndex != -size){
				if(currIndex != index%size){
					currIndex--;
					currNode = currNode.getPrev();
					prevNode = prevNode.getPrev();
					nextNode = nextNode.getPrev();
				}else{				
					newNode.setNext(nextNode);
					newNode.setPrev(currNode);
					currNode.setNext(newNode);
					nextNode.setPrev(newNode);			
					currNode = newNode;
					size++;
					break;										
				}
			}	
		}
	}
	/**
	 * Returns the data stored at the specified index.
	 * 
	 * @param index The index determines the node whose data is returned.
	 * @return Returns the data of the node at the index.
	 */
	public E get(int index){//returns the data stored at the specified index
		int currIndex = 0;
		DoubleLinkedNode<E> currNode = this.head;
		E temp = null;		
		if(index == 0){//zero case			
			temp = currNode.getData();
		}
		else if(index > 0){//positive			
			while(currIndex != size){
				if(currIndex != index%size){
					currIndex++;
					currNode = currNode.getNext();								
				}else{								
					temp = currNode.getData();
					break;										
				}
			}	
		}
		else if(index < 0){//negative		
			while(currIndex != -size){
				if(currIndex != index%size){
					currIndex--;
					currNode = currNode.getPrev();
				}else{				
					temp = currNode.getData();
					break;										
				}
			}			
		}
		return temp;
	}	
	/**
	 * Which removes and returns an item from the list.
	 * 
	 * @param index Removes the node at the current index.
	 * @return Returns the data of the removed node.
	 */
	public E remove(int index){//which removes and returns an item from the list
		int currIndex = 0;
		DoubleLinkedNode<E> currNode = this.head;
		DoubleLinkedNode<E> nextNode = this.head.getNext();
		DoubleLinkedNode<E> prevNode = this.head.getPrev();
		E temp = null;	
		if(index == 0){
			temp = currNode.getData();
			prevNode.setNext(currNode.getNext());
			nextNode.setPrev(currNode.getPrev());
			this.head = nextNode;
			size--;
		}
		else if(index > 0){//positive			
			while(currIndex != size){
				if(currIndex != index%size){
					currIndex++;
					currNode = currNode.getNext();
					nextNode = nextNode.getNext();
					prevNode = prevNode.getNext();					
				}else{								
					temp = currNode.getData();
					prevNode.setNext(currNode.getNext());
					nextNode.setPrev(currNode.getPrev());
					currNode = nextNode;
					size--;
					break;										
				}
			}	
		}
		else if(index < 0){//negative		
			while(currIndex != -size){
				if(currIndex != index%size){
					currIndex--;
					currNode = currNode.getPrev();
					prevNode = prevNode.getPrev();
					nextNode = nextNode.getPrev();
				}else{				
					temp = currNode.getData();
					prevNode.setNext(currNode.getNext());
					nextNode.setPrev(currNode.getPrev());
					currNode = prevNode;
					size--;
					break;										
				}
			}			
		}
		return temp;
	} 
	/**
	 * Returns the size.
	 * 
	 * @return
	 */
	public int size(){
		return size;
	}
	@Override public String toString(){
		String str = "[";
		int index = 0;
	    DoubleLinkedNode<E> curr = head;
	    if(size == 0){
	    	return "There is no one here to kill.";	    	
	    }else{	    
	    	while (index < size) {
	    		str += curr.getData();  
	    		curr = curr.getNext();
	    		index++;
	    			if (index < size) {
	    				str += ", ";
	    			}
	    	}
	    		str += "]";
	    }
	    return str;
	  }	
	@Override
	public ListIterator<E> iterator() {

		return new CircularDoubleIterator();
	}	
	// Iterator inner class begins
	private class CircularDoubleIterator implements ListIterator<E> {
		private DoubleLinkedNode<E> prevItem;
		private DoubleLinkedNode<E> nextItem;//reference to next item
		private int index = 0;
		private DoubleLinkedNode<E> lastReturned;// the last node to be returned by prev() or next(), reset to null after a remove() or add()
												

		@Override
		public E next() {
			if(!hasNext()){
				throw new NoSuchElementException("No such element.");
			}
			else{				
				nextItem = head;
				lastReturned = nextItem;
				nextItem = nextItem.getNext();
				head = nextItem;
				index++;
				return lastReturned.getData();				
			}
		}
		@Override
		public E previous() {
			if(!hasPrevious()){
				throw new NoSuchElementException("No such element.");
			}
			else{		
			prevItem = head;
			lastReturned = prevItem.getPrev();
			prevItem = prevItem.getPrev();
			head = prevItem;
			index--;		
			return lastReturned.getData();
			}
		}
		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index-1;
		}
		@Override 
		public boolean hasNext() {	
			return size != 0;
		}
		
		@Override
		public boolean hasPrevious() {		
			return size!= 0;
		}
		@Override
		public void remove() {//removes first time but acts weird a second
			if(lastReturned == null){
				throw new IllegalStateException();
			}
			DoubleLinkedNode<E> tempPrev = lastReturned.getPrev();
			DoubleLinkedNode<E> tempNext = lastReturned.getNext();
			tempPrev.setNext(tempNext);
			tempNext.setPrev(tempPrev);
			size--;
			if(nextItem == lastReturned){
				nextItem = tempNext;
			}
			else{
				index--;
				lastReturned = null;
			}
		}

		@Override
		public void set(E theData) {//does not work, sets data opposite where it should be
			if(lastReturned == null){
				throw new IllegalStateException();
			}
			else{
				lastReturned.setData(theData);			
			}			
		}
		@Override
		public void add(E theData) {//adds but the old head moves to end of list
			DoubleLinkedNode<E> newNode = new DoubleLinkedNode<E>(theData);
			if(size == 0){				
				newNode.setPrev(newNode);
				newNode.setNext(newNode);
				//nextItem = newNode;
				//prevItem = newNode;
				head = newNode;
				size++;
				index++;
				lastReturned = null;
			}
			else if(size != 0){				
				nextItem = head;
				
				prevItem = head.getPrev();
				newNode.setNext(nextItem);
				newNode.setPrev(prevItem);	
				
				nextItem.setPrev(newNode);
				prevItem.setNext(newNode);				
				head = nextItem;
	            size++;
	            index++;
	            lastReturned = null;
			}
			
		}
		
	}
	
	//Iterator inner class ends
}
