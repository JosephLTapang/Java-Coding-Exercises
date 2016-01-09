/**
 * @(#)CreateSegments.java
 *
 *
 * @author Joseph L. Tapang
 * @version 1.00 2013/9/13
 */

public class CreateSegments {
	/**
	 *default constructor
	 */
    public CreateSegments() {
    }   
    /**
     *method that accepts four SegmentInterface variables
     */
    public static void printFour(SegmentInterface seg1, SegmentInterface seg2, SegmentInterface seg3, SegmentInterface seg4){
        System.out.print(seg1 + "\n" + seg2 + "\n" + seg3 + "\n" + seg4);
   	}
    /**
     *method that creates the four segments, 
     *prints them out,
     *moves the last segment,
     *and prints out the four segments again
     */
    static void unitTest(){
   		
   		Point point1 = new Point(1,2);
		Point point2 = new Point(4,5);
		Segment segment1 = new Segment(point1, point2);
		
		Point point3 = new Point(1,2);
		Point point4 = new Point(4,2);
		Segment segment2 = new Segment(point3, point4);
		
		Point point5 = new Point(4,5);
		Point point6 = new Point(4,2);
		Segment segment3 = new Segment(point5, point6);
		
		Point point7 = new Point(0,0);
		Point point8 = new Point(7,1.5);
		Segment segment4 = new Segment(point7, point8);
	
		printFour(segment1, segment2, segment3, segment4);
	
		segment4.move(segment4, 5.3, 0, 0, 5);
		
		System.out.print("\n" + "Segments after movement: " + "\n");
		
		printFour(segment1, segment2, segment3, segment4);
    }	
}