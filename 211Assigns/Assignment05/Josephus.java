/**
 * @(#)Josephus.java
 * @author Joseph L. Tapang
 * @version 1.00 2013/11/10
 */
import java.util.LinkedList;
import java.util.ListIterator;

public class Josephus {
	
	public LinkedList<Integer> testList(int size, int start, int step, boolean isClockwise){	
		
		CircularDoubleLinkedList<Integer> startList = new CircularDoubleLinkedList<Integer>();//initial list of testee's
		
		LinkedList<Integer> endList = new LinkedList<Integer>();//list containing the dead guys and the one survivor
		
		ListIterator<Integer> it = startList.iterator();
		
		for(int i = 0; i <size; i++){
           it.add(i+1);// creates the list to test to the specified size
		}	
		System.out.println(startList);
		int mod = start % size;
		if (mod == 0){
			for (int i = 0; i<size; i++){
				it.previous();
			}
		}
		else{		
			if(start<0){
				for(int i = 0; i<mod* -1; i++){
					it.previous();
				}
			}
			else if(start>0){
				for(int i= 0; i<mod - 1;i++){
					it.next();
				}
			}		
			//postive
			if(isClockwise){
				while(size!=0){			
					for(int i= 0; i<step; i++){				
						it.next();
					}			
					endList.add(it.previous());
					it.next();
					it.remove();
					size--;
				}
				return endList;
			}
			if(!isClockwise){
				while(size!=0){			
					for(int i= 0; i<step; i++){				
						it.previous();
					}			
					endList.add(it.next());
					it.previous();
					it.remove();
					size--;
				}
				return endList;
			}
		}
			return endList;	
	}	
	//Test Class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Josephus newTest = new Josephus();
		
		System.out.print(newTest.testList(6, -10, 4, true));
	}
} 


/**
size - number of people in circle
start - the position of where to start counting from
step - predetermined number for counting off
isClockwise - if isClockwise is true, counting occurs in a clockwise manner. 
If isClockwise is not true, then counting occurs in a counter-clockwise manner.
testList returns a LinkedList<Integer> (you can use Java's Linked List for this) 
of the people in the order that they were removed. The last person standing should be the last person in this list.

Feel free to implement other methods in any of the classes which will help solve this problem.
*/