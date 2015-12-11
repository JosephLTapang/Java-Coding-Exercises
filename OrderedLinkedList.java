/**
 *@(#)OrderedLinkedList.java
 *
 *@author Joseph L. Tapang
 *@version 1.00 2013/9/27
 */
 
/**
 * This is the outer class. 
 * 
 */
public class OrderedLinkedList<E>{
   
   private int size;
   
   private int index;
   
   private int counter;
   
   private KeyedNode head;
   
   /**
    * Constructor that creates the head node that points to null and initializes size to 0.
    */
   public OrderedLinkedList(){
	  head = new KeyedNode(null,"");
	  size = 0;
   }
   /**
    * Method that goes through the OrderedLinkedList and adds one to counter then returns counter as the size.
    * 
    * @return Returns the int variable counter.
    */
   public int size(){	   
	   KeyedNode currNode = head;
	   while(currNode.getNext() != null){
		   currNode = currNode.getNext();
		   counter++;
	   }
	   return counter;
   }
   
 //below not done
 //add method needs to order using String.compareToIgnoreCase
 //add method needs to increment size when done adding
 //add needs to add to front/middle/end of the list if node doesn't exist, if node does exist it needs to replace 
 //the value of the node which shares the key with the add method
 
   public E add(String key, E value){
	  KeyedNode currentNode = head;
	  //need index to get index of prev node
	  while(currentNode != null){
	  	if(key.compareToIgnoreCase(currentNode.getKey()) < 0){
	  		//need to find the index of the previous node then get previous node and set its next to new node and new nodes next to prev nodes next
	  		//KeyedNode temp = new KeyedNode(value, key, currentNode.get(index-1));	
	  	}
	  	else if(key.compareToIgnoreCase(currentNode.getKey()) == 0){//replaces current with new
	  		 KeyedNode temp = new KeyedNode(value, key, currentNode.getNext());	
	  	}
	  	else if(key.compareToIgnoreCase(currentNode.getKey()) > 0){//add to right
	  		//KeyedNode temp = new KeyedNode(value, key, nextref);	
	  	}
	  	else if(size == 0){//add to empty
	  		 KeyedNode temp = new KeyedNode(value, key);	
	  	}
	  	currentNode = currentNode.getNext();
	  	index++;
	  }
	   currentNode.setNext(temp);
		size++;
   }
 
//above not done
//below is a test add method that doesn't order the linked list.
  /**
   public void add(String key, E value){
		KeyedNode temp = new KeyedNode(value, key);
		KeyedNode current = head;
		// Starts at head node and cycles through the list.
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		size++;// increment the number of elements variable
	}
/**
 * Method that looks through the keys of the OrderedLinkedList nodes and returns the data of the node.
 * @param key The String key parameter used to search the OrderedLinkedList.
 * @return Returns the data of the node with the matching key.
 */
  public E find(String key){
	  KeyedNode current = head;
		// Starts at head node and cycles through the list.
		while(current.getNext() != null){
			current = current.getNext();
			if(current.getKey().equals(key)){
				break;
			}else{
				return null;
			}
		}
		return current.getData();
  }
/**
 * Method that creates an index for the OrderedLinkedList, then uses the index to find the position of a node to return.
 *  
 * @param position Position is an int variable used to match with index to find a node.
 * @return Returns the data of the node in the desired position.
 */
public E get(int position){//still needs null.
	KeyedNode current = head;
	index = 0;
	if(position < 0 || position >= size){
		//return null;
		throw new NullPointerException("The whole grain bagel you have entered is not a valid position. Only numbers >=0 or < the size of the OrderedLinkedList.");
		
	}
	while(current != null){
		
		current = current.getNext();
		if(index == position){
			break;
		}
		index++;
	}
	return current.getData();
}
/**
 * Private inner class  KeyedNode of OrderedLinkedList begins.   
 */
   private class KeyedNode{
      
      private String key;
         
      private E data;
      
      private KeyedNode next;
      
      public  KeyedNode(E dataItem, String keyWord){
         data = dataItem;
         key = keyWord;
         next = null;
      }
      
      public  KeyedNode(E dataItem, String keyWord, KeyedNode nodeRef){
         data = dataItem;
         key = keyWord;
         next = nodeRef;
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
      public void setData(E nodeData){
         data = nodeData;
      }
      
      public void setNext(KeyedNode nodeNext){
         next = nodeNext;
      }
      
      public void setKey(String nodeKey){
         key = nodeKey;
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

