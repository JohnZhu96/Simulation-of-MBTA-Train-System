/**
 * This class represents a red line railway and is made up of a list of Stations. All trains hold a specified number of passengers in an array.
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package main;

public class Railway {

	public DoubleLinkedList<Station> railway;
	public String[] stationNames;
	public int count;
	
	/**
	 * Constructs an empty Railway
	 */
	public Railway() {
		this.railway=new DoubleLinkedList<Station>();
		this.stationNames=new String[18];
		this.count = 0;	
	}
	
	/**
	 * Adss a Station to the Railway
	 * @param s
	 */
	public void addStation(Station s) {
		stationNames[count]=s.stationName();
		railway.insert(s);
		count++;
	}
	
	/**
	 * Sets the Rider's direction and adds the Rider to the appropriate Station
	 * @param r
	 */
	public void addRider(Rider r) {
		setRiderDirection(r);
		String starting=r.getStarting();
		Node<Station> curr=railway.getFirst();
		while(curr.next!=null) {
			if(curr.data.stationName().equals(starting)) {
				curr.data.addRider(r);
			}
			curr=curr.next;
		}
		
	}
	
	/**
	 * Adds a Train to the appropriate Station in this Rail way
	 * @param t
	 */
	public void addTrain(Train t) {
		Node<Station> curr=railway.getFirst();
		while(curr.next!=null) {
			if(curr.data.stationName().equals(t.currentStation)) {
				curr.data.addTrain(t);
			}
			curr=curr.next;
		}
	}
	
	/**
	 * Sets a Rider's direction based on the Rider's starting and ending Stations
	 * @param r
	 */
	public void setRiderDirection(Rider r) {
		int start=0;
		int destination=0;
		for(int i=0;i<count;i++) {
			if(stationNames[i].equals(r.getStarting())) {
				start =i;
			}else if(stationNames[i].equals(r.getDestination())) {
				destination=i;
			}
		}
		if(start<destination) {  //if the starting station is before the destination
			r.direction=1;
		}else {  //if the starting station is after the destination
			r.direction=0;
		}
	}
	
	/**
	 * Executes one simulation of the Railway
	 * @return
	 */
	public String simulate() {
		String output = "";
		Node<Station> curr = railway.getFirst();
		
		while(curr.data!=null) {
			Station sta=curr.data;
			output += sta.toString()+"\n";
			boolean goSouth = false;
			boolean goNorth = false;
			Queue<Train> south = sta.southBoundTrains;
			Queue<Train> north = sta.northBoundTrains;
			
			if(south.front()!=null) {
				if(sta.stationName().equals("Braintree")) {
					goSouth=true;
				}else {
					Train data = sta.southBoardTrain();
					sta = curr.next.data;
					data.updateStation(sta.stationName());
					output+=sta.addTrain(data)+"\n";
				}
			}
			sta=curr.data;
			if(north.front()!=null) {
				if(sta.stationName().equals("Alewife")) {
					goNorth=true;
				}else {
					Train data=sta.northBoardTrain();
					sta = curr.prev.data;
					data.updateStation(sta.stationName());
					output += sta.addTrain(data)+"\n";
				}	
			}
			if(goSouth) {
				sta=curr.data;
				sta.moveTrainSouthToNorth();
			}
			if(goNorth) {
				sta=curr.data;
				sta.moveTrainNorthToSouth();
			}
			curr=curr.next;
		}
		return output;
	}
	
	/**
	 * Returns the Stations list's String representation
	 */
	@Override
	public String toString() {
		String result="";
		Node<Station> curr=railway.getFirst();
		while(curr.next!=null) {
			result+=curr.data.toString() +"\n";
			curr=curr.next;
		}
		return result;
	}
}