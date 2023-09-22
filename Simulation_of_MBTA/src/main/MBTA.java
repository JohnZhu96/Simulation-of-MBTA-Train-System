/**
 * This class contains the main method and run a simulation of a Railway
 * Known Bugs: None
 *
 * @author Linfeng Zhu
 * linfengzhu@brandeis.edu
 * Oct 5, 2022
 * COSI 21A PA1
 */
package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MBTA {

	public static final int SOUTHBOUND = 1;
	public static final int NORTHBOUND = 0;
	
	static final int TIMES = 6;
	static Railway r;
	
	/**
	 * This is the main class to run the program
	 * @param args is the command line parameter required for the signature of the method
	 * @throws FileNotFoundException throw an exception if a file cannot be found 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		r = new Railway();
		
		Scanner console=new Scanner(System.in);
		System.out.println("Name of trainFile: ");
		String trainsFile = console.nextLine();
		System.out.println("Name of ridersFile: ");
		String ridersFile = console.nextLine();
		System.out.println("Name of stationsFile: ");
		String stationsFile = console.nextLine();
		
		
		initStations(stationsFile);
		initRiders(ridersFile);
		initTrains(trainsFile);
		
		runSimulation();
	}
	
	/**
	 * This is a method to runStimulation
	 * 
	 */
	public static void runSimulation() {
		String result= "INITIATED RED LINE \n" +"\n"+ r.toString() + "BEGINNING RED LINE SIMULATION \n" +"\n";
		for(int i=1;i<=TIMES;i++) {
			result+= " ------ " + i + " ------ \n" +"\n" + r.simulate();
		}
		System.out.println(result);
	}
	
	/**
	 * This is a method to initialize trains
	 * @param trainsFile the name of the file which will be read
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * 
	 */
	public static void initTrains(String trainsFile) throws FileNotFoundException {
		Scanner console=new Scanner(new File(trainsFile));
		while(console.hasNext()) {
			String station=console.nextLine();
			int direction=console.nextInt();
			console.nextLine();
			Train a =new Train(station,direction);
			r.addTrain(a);
		}
	}
	
	/**
	 * This is a method to initialize riders
	 * @param ridersFile the name of the file which will be read
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * 
	 */
	public static void initRiders(String ridersFile) throws FileNotFoundException {
		Scanner console=new Scanner(new File(ridersFile));
		while(console.hasNextLine()) {
			String riderID = console.nextLine();
			String starting = console.nextLine();
			String destination = console.nextLine();
			Rider a = new Rider(riderID,starting,destination);
			r.addRider(a);
			
		}
	}
	
	/**
	 * This is a method to initialize stations
	 * @param stationsFile the name of the file which will be read
	 * @throws FileNotFoundException throw an exception if a file cannot be found
	 * 
	 */
	public static void initStations(String stationsFile) throws FileNotFoundException {
		Scanner console = new Scanner(new File(stationsFile));
		while(console.hasNextLine()) {
			Station s = new Station(console.nextLine());
			r.addStation(s);
		}
	}
}