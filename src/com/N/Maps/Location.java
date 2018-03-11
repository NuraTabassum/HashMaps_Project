package com.N.Maps;

import java.util.HashMap;
import java.util.Map;

public class Location {
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits; // exit is also similar to
												// location which is string and
												// Integer(LocationID)
	// every location has a map of exits and the Map is consist of string and
	// integer

	public Location(int locationID, String description) {
		this.locationID = locationID;
		this.description = description;
		this.exits = new HashMap<String, Integer>();
		this.exits.put("Q", 0);
	}

	public void addExit(String direction, int location) {// will add the exits
		exits.put(direction, location);
	}

	public int getLocationID() {
		return locationID;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {// give the list of exits
		return new HashMap<String, Integer>(exits);// creating a shallow copy of
													// exits because we dont
													// want other people
		// to change the order of our exits so instead sending the exits
		// directly we are sending shallow copy of our exits.
	}

}
