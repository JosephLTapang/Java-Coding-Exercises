/**
 * @(#)SegmentInterface.java
 *
 *
 * @author Joseph L. Tapang
 * @version 1.00 2013/9/13
 */


public interface SegmentInterface {
    /**
     *method to determine the point at the left end of the segment
     */
    Point left(Point point1, Point point2); 
	/**
	 *method to determine the point at the right end of the segment
	 */
    Point right(Point point1, Point point2); 
	/**
	 *method to determine the point at the upper end of the segment
	 */
    Point upper(Point point1, Point point2); 
	/**
	 *method to determine the point at the lower end of the segment
	 */
    Point lower(Point point1, Point point2); 
	/**
	 *method that determines the length of the segment, that is, the distance between its endpoints
	 */
    double length(Segment segment); 

}