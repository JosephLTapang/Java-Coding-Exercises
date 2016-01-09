/**
 * @(#)ArrayQueue.java
 * @author Joseph L. Tapang
 * @version 1.00 2013/25/10
 * 
 */

public class ArrayQueue<E> {
	private E[] queue;	
	private int size = 0;
	private int front;		
	private int rear;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(){
		queue = (E[])new Object[10];
		front = 0;
		rear = queue.length -1;
		capacity = 10;
	}
	/**
	 * This method offers a value to the array based queue.
	 * @param value Value is the data to be added to the queue.
	 * @return Returns true if the offer is successful or false if it is not.
	 */
	public boolean offer (E value){	    
		if(value == null){
			return false;
		}
		for(int i = front; i <= rear; i++){
			if(value.equals(queue[i])){
				return false;
			}
		}
		if(size == 10){
			return false;
		}
		else{			
			size++;
			rear = (rear + 1) % capacity; //Used the idea of capacity from lecture and book.		
			queue[rear] = value;		
			return true;
		}
	}
	/**
	 * This method returns the data at the array index front and "removes" it from the queue. 
	 * @return Returns the data stored in the temporary variable temp or null if the queue is empty.
	 */
	public E poll(){
		if(size == 0){
			return null;
		}		
		E temp = queue[front];
		front = (front + 1) % capacity;
		size--; 			
		return temp;
	}
	
	public static void main(String[] args) {//Test code
		ArrayQueue<String> queue = new ArrayQueue<String>();

		queue.offer("A");
		System.out.print(queue.poll());
		queue.offer("B");
		System.out.print(queue.poll());
		System.out.print(queue.poll());
		queue.offer("A");
		queue.offer("B");
		System.out.print(queue.poll());
		queue.offer("A");
		System.out.print(queue.poll());
		System.out.print(queue.poll());
	}
}