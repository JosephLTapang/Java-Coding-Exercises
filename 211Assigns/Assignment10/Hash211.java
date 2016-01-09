/**
 * @Assignment11
 * @(#) Hash211.java
 * @author Joseph Lee Tapang
 * @ 11/26/13
 */
import java.util.LinkedList;
import java.lang.Math;

public class Hash211<K, V>{

	private LinkedList<Entry<K, V>> [] array;

	private int capacity;

	private boolean printTimes;

	//The number of linked lists or slots filled in array.
	private int size;

	//The combined number of elements in all the linked lists in the array.
	private int numElements; 

	@SuppressWarnings("unchecked")
	public Hash211(int capacity, boolean printTimes){
		this.capacity = capacity; 
		array = new LinkedList[capacity];
		this.printTimes = printTimes;
	}
	
	/**
	 * This method adds or replaces a Key,Value.
	 * @param key The key of an Entry object.
	 * @param value The value of the Entry object.
	 * @return Returns the old value of the key.
	 */
	public V put(K key, V value){
		System.nanoTime();
		int index = theHasher(key);

		if(array[index] == null){
			array[index] = new LinkedList<Entry<K, V>>();
			size++;
		}		
		for(Entry<K, V> nextItem : array[index]){
			if(nextItem.getKey().equals(key)){
				V temp = nextItem.getValue();
				nextItem.setValue(value);
				return temp;//Previous value is returned.
			}
		}
		array[index].addFirst(new Entry<K, V>(key, value)); // addFirst method from Java LinkedList
		numElements++;
		long sysTime = System.nanoTime();
		if(printTimes == true){
			System.out.print("This put process took " + sysTime + " nanoseconds." + "\n");
		}
		return null;//No previous value to return.
	}
	
	/**
	 * This method searches the table for the given key and returns its value.
	 * @param key The key to be searched for.
	 * @return Returns the value at the array location if the key matches.
	 */
	public V get(K key){//return a value from the given key
		System.nanoTime();
		
		int index = theHasher(key);
		if(array[index] == null){
			return null;
		}
		for(Entry<K, V> nextItem : array[index]){
			if(nextItem.getKey().equals(key)){				
				long sysTime = System.nanoTime();
				if(printTimes == true){
					System.out.print("This get process took " + sysTime + " nanoseconds." + "\n");
				}
				return nextItem.getValue();
			}
		}
		return null;
	}

	/**
	 * This method applies hash code, absolute value, and % to get the index from the given key.
	 * @param key The key of the Entry object to he hashed.
	 * @return Returns the integer that is the resulting index.
	 */
	public int theHasher(K key){ 
		int hashedKey = Math.abs(key.hashCode());
		int index = hashedKey % capacity;
		return index;
	}

	//Inner object class that defines an object containing a key,value BEGINS.
	@SuppressWarnings("hiding")
	private class Entry<K, V>{// taken from Chapter 7 of book
		private K key;

		private V value;

		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey(){
			return key;
		}
		public V getValue(){
			return value;
		}
		public V setValue(V val){
			V temp = value;
			value = val;
			return temp;
		}
	}
	//Inner object class that defines an object containing a key,value ENDS.
}
//Analysis of put and get methods BEGINS.    
/**
 *				99,171 elements with a size 10 times less	     					
 *      
 *             		PUT                     GET				
 *   	-----------------------------------------------------
 *   	|													|
 *  1st |		313,663,443 ns			349,918,556 ns		|
 *   	|													|
 *  2nd |   	307,856,238 ns			347,502,717 ns		|
 *   	|													|
 *  3rd |		304,118,534 ns			344,663,313 ns		|
 *   	|													|
 *   	-----------------------------------------------------
 *   Average:   308,546,071 ns			347,361,528 ns
 *   
 *   
 *    		99,171 elements with a size 10 times greater     					
 *      
 *             		PUT                     GET				
 *   	-----------------------------------------------------
 *   	|													|
 *  1st |		306071009 ns			182975040 ns		|
 *   	|													|
 *  2nd |   	291283649 ns			185343026 ns		|
 *   	|													|
 *  3rd |		289841443 ns			184483577 ns		|
 *   	|													|
 *   	-----------------------------------------------------
 *   Average:   295,732,033 ns			184,267,214 ns
 *   
 *   
 *   The difference between average PUT was: 12,814,038 ns or an ~4% difference in ns.
 *   
 *   The difference between average GET was: 163,094,314 ns or an ~61% difference in ns.
 *   
 *   In general having a table size 10 times larger decreased the time spent in the test.
 *   In the case of the GET method the time spent was considerably decreased.
 *   
 */
//Analysis of put and get methods ENDS.  