/**
 * This class represents a Rider on the red line
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package main;

public class Rider {
	
	public String riderID;
	public String starting;
	public String destination;
	public int direction;

	/**
	 * Constructs a Rider with an ID as well as starting and ending station
	 * @param riderID
	 * @param startingStation
	 * @param destinationStation
	 */
	public Rider(String riderID, String startingStation, String destinationStation) {
		this.riderID=riderID;
		this.starting=startingStation;
		this.destination=destinationStation;
		this.direction=1;
	}
	
	/**
	 * Returns the name of this Rider's starting station
	 * @return
	 */
	public String getStarting() {
		return this.starting;
	}
	
	/**
	 * Returns the name of this Rider's ending station
	 * @return
	 */
	public String getDestination() {
		return this.destination;
	}
	
	/**
	 * Returns this Rider's Id
	 * @return
	 */
	public String getRiderID() {
		return this.riderID;
	}
	
	/**
	 * Returns true if this Rider is northbound
	 * @return
	 */
	public boolean goingNorth() {	
		return this.direction==0;
	}
	
	/**
	 * Swaps the Rider's current direction
	 */
	public void swapDirection() {
		if(this.goingNorth()) {
			this.direction=1;
		}else {
			this.direction=0;
		}
	}
	
	/**
	 * Returns a String representation of this Rider
	 */
	@Override
	public String toString() {
		String s=riderID+","+starting+","+destination+",";
		if(this.goingNorth()) {
			s +="Northbound";
		}else {
			s +="Southbound";
		}
		return s;
	}
	
	/**
	 * Checks if this Rider is equal to another Object based on ID
	 */
	@Override
	public boolean equals(Object s) {
		if(s instanceof Rider) {
			Rider r = (Rider) s;
			return r.riderID.equals(this.riderID);
		}
		return false;
	}
}