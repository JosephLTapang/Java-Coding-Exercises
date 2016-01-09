/**
 * @(#)Segment.java
 *
 *
 * @author Joseph L. Tapang
 * @version 1.00 2013/9/13
 */


public class Segment implements SegmentInterface{
    
   Point firPoint = new Point();
   
   Point secPoint = new Point(); 
   	
   double moveDistanceX;
   
   double moveDistanceY;
    /**
     *default constructor
     */
    public Segment() {
    }
    /**
     *Segment constructor that accepts two Point parameters
     */
    public Segment(Point point1, Point point2){
    	firPoint = point1;
    	secPoint = point2;
    }
    /**
    *method to determine the point at the left end of the segment
    */    
    public Point left(Point point1, Point point2){ 
    	if(point1.getX() < point2.getX()){    		
    		return point1;
	   	}
	   	else{	   	
    		return point2;
	   	}
    }
    /**
	 *method to determine the point at the right end of the segment
	 */
    public Point right(Point point1, Point point2){
    	if(point1.getX() > point2.getX()){
    		return point1;
    	}
    	else{    
    		return point2;
    	}
    }
    /**
	 *method to determine the point at the upper end of the segment
	 */    
    public Point upper(Point point1, Point point2){
    	if(point1.getY() > point2.getY()){    		
    		return point1;
    	}
    	else{    		
    		return point2;
    	}
    }
    /**
	 *method to determine the point at the lower end of the segment
	 */
    public Point lower(Point point1, Point point2){
    	if(point1.getY() < point2.getY()){    		
    		return point1;
    	}
    	else{    		
      		return point2;
    	}
    }
    /**
	 *method that determines the length of the segment, that is, the distance between its endpoints
	 */
    public double length(Segment segment){
          Point pointA = new Point();
          Point pointB = new Point();
          pointA = segment.getFirPoint();
          pointB = segment.getSecPoint();
          return Point.distance(pointA, pointB);
    }
    
    //getters
    public Point getFirPoint(){
    	return firPoint;
    }   
    	
    public Point getSecPoint(){
    	return secPoint;
    }
    /**
     *method that determines if segment is horizontal
     */
    public boolean isHorizontal(Point point1, Point point2){
    	if(point1.getY() == point2.getY()){    		
    		return true;
    	}
    	else{    		
    		return false;
    	}
    }
    /**
     *method to determine if segment is vertical
     */
    public boolean isVertical(Point point1, Point point2){
    	if(point1.getX() == point2.getX()){    	
    		return true;
    	}
    	else{  
    		return false;
    	}
    }
    /**
     *method to move the segment
     *This is done by adding or subtracting a desired amount with x and y of each point.
     *The first argument identifies the segment to move
     *The second argument determines the distance left or right
     *The third argument determines the distance up or down
     *The fourth argument determines if you want to move left or right
     *The fifth argument determines if you want to move up or down
     */
    public void move(Segment segToMove, double moveDistX, double moveDistY, int leftOrRight, int upOrDown){
    	/**
    	 *gets the first point of the segment to move and places it in newPointA
    	 */
    	Point newPointA = segToMove.getFirPoint();
    	/**
    	 *gets the second point of the segment to move and places it in newPointB
    	 */
    	Point newPointB = segToMove.getSecPoint();
  		/**
  		 *gets the x's and y's of each point and places them in xA, xB, yA, and yB
  		 */
    	double xA = newPointA.getX();
    	double yA = newPointA.getY();
       	double xB = newPointB.getX();
    	double yB = newPointB.getY();
		/**
		 *switch statement where 0 is left, 1 is right and default does nothing
		 */
    	switch(leftOrRight){
    		case 0:
    			double leftNewXA = xA - moveDistX;
       			double leftNewXB = xB - moveDistX;
       			newPointA.setX(leftNewXA);
       			newPointB.setX(leftNewXB);
       			break;
       		case 1:
       			double rightNewXA = xA + moveDistX;
       			double rightNewXB = xB + moveDistX;
       			newPointA.setX(rightNewXA);
       			newPointB.setX(rightNewXB);
       			break;
    		default:
    			break;
    	}		
		/** 
		 *switch statement where 0 is up, 1 is down, and default does nothing
		 */
		switch(upOrDown){
			case 0:
				double upNewYA = yA + moveDistY;
       			double upNewYB = yB + moveDistY;
       			newPointA.setY(upNewYA);
       			newPointB.setY(upNewYB);
       			break;
			case 1:
				double downNewYA = yA - moveDistY;
       			double downNewYB = yB - moveDistY;//moveDistanceY(moveDistY);
       			newPointA.setY(downNewYA);
       			newPointB.setY(downNewYB);
       			break;
       		default:
       			break;	
			}
    }
    /**
     *toString method that returns the left and right point if isHorizontal is true. If it is not true then return the lower and upper point
     */
    public String toString(){
   		if(isHorizontal(firPoint, secPoint)){
   			return "Left point: " + left(firPoint, secPoint) + "\n" + "Right point: " + right(firPoint, secPoint);
   		}
   		else{
   			return "Lower point: " + lower(firPoint, secPoint) + "\n" + "Upper point: " + upper(firPoint, secPoint);
   		}
    }
}