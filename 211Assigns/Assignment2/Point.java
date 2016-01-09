/**
 * @(#)Point.java
 *
 *
 * @author Joseph L. Tapang
 * @version 1.00 2013/9/13
 */

import java.lang.Math;
public class Point {
	
	private double x;

	private double y;
	
	/**
	 *default constructor
	 */
    public Point() {
    }
	/**
	 *constructor that accepts two double variables
	 */
    public Point(double x, double y){
      this.x = x;
      this.y = y;
    }    
	//getters
    public double getX(){ 
    	return x ; 
    }
    public double getY(){
    	return y ; 
    }    
    //setters
    public void setX(double x){
    	this.x = x;
    }    
    public void setY(double y){
    	this.y = y;
    }
	/**
	 *method that returns the distance between the two points
	 */
    public static double distance(Point point1, Point point2){
		double dx = point1.getX() - point2.getX();
		double dy = point1.getY() - point2.getY();
		return Math.sqrt(dx*dx + dy*dy);
    } 
	/**
	 *string overried that returns x and y in the form of a point
	 */
    public String toString(){
		return "(" + x + "," + y + ")";
    }


}