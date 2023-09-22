/**
 * This class represents a Train on the red line. All trains hold a specified number of passengers in an array.
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package main;

public class Train {

	public static final int TOTAL_PASSENGERS = 10;
	public Rider[] passengers;
	public int passengerIndex;
	
	public int direction;
	public String currentStation;
	
	/**
	 * Constructs an empty Train at a given Station going either south(1) or north(0)
	 * @param currentStation
	 * @param direction
	 */
	public Train(String currentStation, int direction) {
		this.passengers=new Rider[TOTAL_PASSENGERS];
		this.passengerIndex=0;
		this.currentStation=currentStation;
		this.direction=direction;
	}
	
	/**
	 * Returns true if this Train is northbound
	 * @return
	 */
	public boolean goingNorth() {
		return direction==0;
	}
	
	/**
	 * Swaps the Train's direction
	 */
	public void swapDirection() {
		if(this.goingNorth()) {
			direction=1;
		}else {
			direction=0;
		}
	}
	
	/**
	 * Returns a String of the current passengers on the Train
	 * @return
	 */
	public String currentPassengers() {
		String output="";
		for(int i=0;i< this.passengerIndex;i++) {
			output += passengers[i].getRiderID() + "," + passengers[i].getDestination() + "\n";
		}
		return output;
	}
	
	/**
	 * Adds a passenger to the Train as long as  (i) the Rider is at the correct Station to enter the Train, 
	 * (ii) the Train is going in the appropriate direction, and (iii) there is space on the Train. 
	 * Return true if the addition was completed. Else, return false.
	 * @param r Instance of a Rider
	 * @return
	 */
	public boolean addPassenger(Rider r) {
		if(r.starting.equals(currentStation) && r.direction==this.direction && this.hasSpaceForPassengers()){
			this.passengerIndex++;
			this.passengers[passengerIndex-1] = r;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if the Train has space for additional passengers
	 * @return
	 */
	public boolean hasSpaceForPassengers() {
		return passengerIndex<TOTAL_PASSENGERS;
	}
	
	/**
	 * This should remove all of the passengers who should be exiting the Train at the Train's current station
	 * @return
	 */
	public String disembarkPassengers() {
		String output = "";
		boolean exiting = false;
		int count =0;
		
		for(int i=0; i<this.passengerIndex; i++) {
			if(passengers[i].destination.equals(currentStation)) {
				exiting = true;
				output += passengers[i].getRiderID()+"\n";
				passengers[i] = passengers[i+1];
				passengerIndex--;
				i--;
			}
		}
		if(exiting == false) {
			return output;
		}
		return output;
	}
	
	/**
	 * Updates the name of this Train's current station to be the name of another station
	 * @param s
	 */
	public void updateStation(String s) {
		this.currentStation=s;
	}
	
	/**
	 * Returns the name of the Train's current Station
	 * @return
	 */
	public String getStation() {
		return this.currentStation;
	}
	
	/**
	 * Returns a String representation of this Train 
	 */
	@Override
	public String toString() {
		String s="";
		if(this.goingNorth()) {
			s="Northbound";
		}else {
			s="Southbound";
		}
		return currentStation+","+s;
	}
}