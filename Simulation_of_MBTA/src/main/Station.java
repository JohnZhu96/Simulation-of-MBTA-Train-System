/**
 * This class represents a Station on the red line. A station should track which Trains and Riders are waiting to 
 * go north or south.
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package main;

public class Station {

	public Queue<Rider> northBoundRiders;
	public Queue<Rider> southBoundRiders;
	public Queue<Train> northBoundTrains;
	public Queue<Train> southBoundTrains;
	public String name;
	
	/**
	 * Constructs an empty Station with a given name
	 * @param name
	 */
	public Station(String name) {
		this.northBoundRiders=new Queue<Rider>(20);
		this.southBoundRiders=new Queue<Rider>(20);
		this.northBoundTrains=new Queue<Train>(20);
		this.southBoundTrains=new Queue<Train>(20);
		this.name=name;
	}
	
	/**
	 * Adds a Rider to the appropriate Queue
	 * @param r An instance of Rider
	 * @return
	 */
	public boolean addRider(Rider r) {
		if(r.goingNorth()) {
			northBoundRiders.enqueue(r);
			return true;
		}else if(!r.goingNorth()){
			southBoundRiders.enqueue(r);
			return true;
		}
		return false;
	}
	
	/**
	 * Moves a Train into this Station, removes all of the passengers who are mean to disembark at this Station
	 * and places the Train in the appropriate Queue depending on its direction
	 * @param r An instance of Rider
	 * @return
	 */
	public String addTrain(Train t) {
		String output = t.disembarkPassengers();
		if(t.goingNorth()) {
			northBoundTrains.enqueue(t);
		}else if(!t.goingNorth()) {
			southBoundTrains.enqueue(t);
		}
		output = this.name + " Disembarking Passengers:\n"+ output;
		String bound = "";
		if(t.goingNorth()) {
			bound = "Northbound";
		}else {
			bound = "Southbound";
		}
		output += "Direction: " + bound + "\n"+"Passengers: \n";
		
		for(int i=0;i<t.passengerIndex;i++) {
				output += t.passengers[i].getRiderID()+","+t.passengers[i].getDestination()+"\n";
		}
		output+="Current station: "+t.currentStation+"\n";
		return output;
	}
	
	/**
	 * This method will prepare a southbound Train of passengers
	 * @return
	 */
	public Train southBoardTrain() {
		if(southBoundTrains==null) {
			return null;
		}
		Train t=southBoundTrains.front();
		southBoundTrains.dequeue();
		while(t!=null&&t.hasSpaceForPassengers()&&southBoundRiders.front()!=null) {
			t.addPassenger(southBoundRiders.front());
			southBoundRiders.dequeue();
		}
		return t;
	}
	
	/**
	 * This method will prepare a northbound Train of passengers
	 * @return
	 */
	public Train northBoardTrain() {
		if(northBoundTrains==null) {
			return null;
		}
		Train t=northBoundTrains.front();
		northBoundTrains.dequeue();
		while(t!=null&&t.hasSpaceForPassengers()&&northBoundRiders.front()!=null) {
			t.addPassenger(northBoundRiders.front());
			northBoundRiders.dequeue();
		}
		return t;
	}
	
	/**
	 * Changes the direction of the first waiting northbound Train and moves it to the southbound Queue
	 */
	public void moveTrainNorthToSouth() {
		Train temp=northBoundTrains.front();
		if(temp!=null) {
			temp.swapDirection();
			southBoundTrains.enqueue(temp);
			northBoundTrains.dequeue();
		}
	}
	
	/**
	 * Changes the direction of the first waiting southbound Train and moves it to the northbound Queue
	 */
	public void moveTrainSouthToNorth() {
		Train temp=southBoundTrains.front();
		if(temp!=null) {
			temp.swapDirection();
			northBoundTrains.enqueue(temp);
			southBoundTrains.dequeue();
		}
	}
	
	/**
	 * Returns the name and status of the Station
	 */
	@Override
	public String toString() {
		String result = "Station: "+name+"\n"+northBoundTrains.size() + " north-bound trains waiting"+"\n"
						+ southBoundTrains.size()+" south-bound trains waiting"+"\n"+northBoundRiders.size()
						+ " north-bound passengers waiting" + "\n"+southBoundRiders.size()
						+ " south-bound passengers waiting" + "\n";
		
		return result;
	}
	
	/**
	 * Returns the name of this Station
	 * @return
	 */
	public String stationName() {
		return name;
	}
	
	/**
	 * Checks if a Station is equal to some object based on name
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Station) {
			Station s = (Station) o;
			return s.stationName().equals(this.name);
		}
		return false;
	}
}