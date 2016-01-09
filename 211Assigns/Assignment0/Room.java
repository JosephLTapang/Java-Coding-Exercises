/**
 * @(#)Room.java
 *
 *
 * @author Joseph L Tapang
 * @version 1.00 2013/9/6
 */


public class Room {
	//Instance variables

	/**
	 *the rooms number
	 */
	private int roomNumber;

	/** is the room occupied or not
	 *
	 */
	private boolean isOccupied;

	/** name of guest
	 *
	 */
	private String guest;

	/** cost per day
	 *
	 */
	private double costPerDay;

	/** number of days guest is staying
	 *
	 */
	int days;

	//Constructors
	public Room(){
	}
	/** Construct a room with values above
	 *
	 */
    public Room(int room, boolean nonVacant, String guestName, double cost, int day) {
    	roomNumber = room;
    	isOccupied = nonVacant;
    	guest = guestName;
    	costPerDay = cost;
    	days = day;
    }

    // getters

    /** gets roomNumber
     *
     */
    public int getRoomNumber(){
    	return roomNumber;
    }

    /** gets isOccupied
     *
     */
    public boolean getIsOccupied(){
    	return isOccupied;
    }

    /** gets guest
     *
     */
    public String getGuest(){
    	return guest;
    }

    /** gets costPerDay
     *
     */
    public double getCostPerDay(){
    	return costPerDay;
    }

    /** gets days
     *
     */
    public int getDays(){
    	return days;
    }

    // setters

    /** sets isOccupied
     *
     */
    public void setIsOccupied(boolean full){
    	this.isOccupied = full;
    }

    /** sets days
     *
     */
    public void setDays(int numDays){
    	this.days = numDays;
    }
	/**
	 * sets costPerDay
	 */
	public void setCostPerDay(int dayCost){
		this.costPerDay=dayCost;
	}
    /** sets guest name
     *
     */
    public void setGuest(String name){
    	this.guest = name;
    }

	/** formats output depending if room is occupied or not
	 *
	 */

	public String toString(){
		if(isOccupied == true){
			return "Room number: " + roomNumber + "\n"+ "Guest name: "
				+ guest + "\n"+ "Cost : " + costPerDay
				+ "\n"+ "Days: " + days + "\n";
		}
		else{
			return "Room number " + roomNumber
				+ " costs " + costPerDay + "\n";
		}
	}


}