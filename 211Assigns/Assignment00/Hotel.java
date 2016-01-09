/**
 * @(#)Hotel.java
 *
 *
 * @author Joseph L Tapang
 * @version 1.00 2013/9/6
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

public class Hotel {
    /**
     * Creates a new instance of <code>Hotel</code>.
     */
    public Hotel() {
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		/**
		 *Creates a two dimensional array full of Room objects
		 */
		Room [][] hotelBuild = new Room[8][20];
			
		for (int floor=0; floor<hotelBuild.length; floor++){
			for (int room=0; room<hotelBuild[floor].length; room++){
				hotelBuild[floor][room]=new Room((floor+1)*100+room+1,false, "", 200,0);
			}
		}
		/**
		 *sets the cost of rooms on floors 5-8 to 350
		 */
		for(int floor=4;floor<hotelBuild.length; floor++){
			for(int room= 0; room<hotelBuild[floor].length; room++){
				hotelBuild[floor][room].setCostPerDay(350);
			}
		}
		/**
		 * creates scanner object "in"
		 */
		Scanner in = new Scanner(System.in);		
		/**
		 *declares the boolean var quit and sets it to false
		 */
		boolean quit = false;
       	/**
    	 * do/while loop that runs menu begins
    	 */
       	do{
			/**
		 	 *prints out list of selection for user
		 	 */
    		System.out.print("1. Guest Registration"  +"\n"+
    			"2. Guest Checkout"  +"\n"+
    			"3. Print list of occupied rooms"  +"\n"+  "4. Exit"+ "\n"+
    		 	"\n" + "Enter a number, 1 through 4 to make a selection: ");
    		/**
    	 	 *declares in var userIn and accepts next integer from user
   		 	 */
   		 	int userIn = -1;
			try {
    			userIn = in.nextInt();
			}catch (InputMismatchException a) {
    			System.out.print( userIn + " is not a valid input");
    			System.out.close();
			}
			/**
		 	 *switch statement that runs in response to the users input
		 	 */
			switch(userIn){			
				/**
			 	 *guest registratoin
			 	 */
				case 1:
				/**
			 	 *receives input of guest name
			 	 */
				System.out.print("Enter the name of the guest: ");
				String guestName = null;
				try{		
					guestName = in.next();
				}catch(InputMismatchException b){
					System.out.print("Try entering " + guestName + " without any spaces and capitolizing the letter of the last name.");
					System.out.close();
				}
				/**
			 	 *receives input of number of days guest will be staying
			 	 */
			 	System.out.print("Number of days guest will be staying: ");
				int daysStay = 0;
			    try{
			   		daysStay = in.nextInt();
			    }catch(InputMismatchException c){
			   		System.out.print("Enter an interger not " + daysStay);
			   		System.out.close();
			    }
				/**
				  *receives input of the floor preference of the guest
			 	 */
				System.out.print("Enter a a floor between 1-8 as preferred: ");
				int floorPref = 0;
				try{
					floorPref = in.nextInt();
				}
				catch(InputMismatchException e){
					System.out.print("Enter an integer 1-8 not " + floorPref);
					System.out.close();
				}
				/**
			 	 *if the guest has a floor preference then the if statement below runs
			 	 */
			 	try{
					if(floorPref != 0){
						for(int room=0; room<hotelBuild[floorPref-1].length; room++){
							if(!hotelBuild[floorPref-1][room].getIsOccupied()){
								System.out.print("Open: " + hotelBuild[floorPref-1][room].getRoomNumber() + "\n");
							}
						}	
					}				
				/**
			 	 *otherwise the else statement runs printing all unoccupied rooms in the hotel
			 	 */
					else{
						for (int floor=0; floor<hotelBuild.length; floor++){
							for(int room=0; room<hotelBuild[floor].length; room++){
								//remove ! to allow to print info of the guest in an occupied room
								if(!hotelBuild[floor][room].getIsOccupied()){
									System.out.print("Open: " + hotelBuild[floor][room].getRoomNumber() + "\n");
								}
							}	
						}
					}	
			 	}catch(ArrayIndexOutOfBoundsException g){
			 		System.out.print("Enter an integer 1-8 not " + floorPref + "!");
			 		System.out.close();
			 	}
				/**
				 *room chosen by user is stored in chosenRoom
				 */
				System.out.print("Choose a room to book: ");
				int chosenRoom = 0;
				try{
					chosenRoom = in.nextInt();
				}catch(InputMismatchException e){
					System.out.print("Enter a valid room number.");
					System.out.close();
				}
				/**
				 *double for loop finds chosenRoom and sets the guest name, number of days staying, and changes occupied to true
				 */
					for (int floor=0; floor<hotelBuild.length; floor++){
						for(int room=0; room<hotelBuild[floor].length; room++){
							if(hotelBuild[floor][room].getRoomNumber()==chosenRoom){
								hotelBuild[floor][room].setGuest(guestName);
								hotelBuild[floor][room].setDays(daysStay);
								hotelBuild[floor][room].setIsOccupied(true);
							}
						}
					}
				break;
		    	/**
		     	*guest checkout
		     	*/
				case 2:
				/**
				 *calculates guests bill, prints guest and rooms info, resets room to empty
				 */
				System.out.print("Enter the guests name that you wish to calculate the bill for: ");
				String guestOut = in.next();
				for (int floor=0; floor<hotelBuild.length; floor++){
						for(int room=0; room<hotelBuild[floor].length; room++){
							if(hotelBuild[floor][room].getGuest().equals(guestOut)){
								double balance = hotelBuild[floor][room].getCostPerDay() * hotelBuild[floor][room].getDays();
								System.out.print("Room number: " + hotelBuild[floor][room].getRoomNumber() +"\n" 
									+ "Guest name: " + hotelBuild[floor][room].getGuest() 
									+ "\n" + "Number of days stayed: " + hotelBuild[floor][room].getDays() + "\n" + "Total balance is: "+ balance + "\n");
								hotelBuild[floor][room].setIsOccupied(false);
							}
						}
					}
				break;
				/**
			 	 *print list of oocupied rooms
			 	 */
				case 3:
				/**
			 	 *prints the occupied rooms in the hotel
			 	 */
				for (int floor=0; floor<hotelBuild.length; floor++){
					for (int room=0; room<hotelBuild[floor].length; room++){
						if(hotelBuild[floor][room].getIsOccupied()){
							System.out.print("\n" + "Occupied: " + hotelBuild[floor][room].getRoomNumber() + "\n");
						}	
					}
				}
				break;
				/**
			 	 *exit case
			 	 */
				case 4:
				//exit program
				quit = true;
				break;
			}
    	}while(!quit);
    	/**
    	 *do while loop ends and system prints end message
    	 */
    	System.out.print("Guest Management Finished");
    }
}
