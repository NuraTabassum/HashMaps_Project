package com.N.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainLocation {
	private static Map<Integer, Location> Locations = new HashMap<Integer, Location>();

	// Map Location inside that we have Map of exits,Map inside a Map
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// define Key 0-5 and value is the new Location which is an object.this
		// is how we initialized our locations
		Locations.put(0, new Location(0, "You are sitting in front of coumputer"));
		Locations.put(1, new Location(1, "You are standing in the end of the road"));
		Locations.put(2, new Location(2, "You are at the top of the hill"));// West
		Locations.put(3, new Location(3, "You are inside a building"));// East
		Locations.put(4, new Location(4, "You are in a vally beside a stream"));// South
		Locations.put(5, new Location(5, "You are in the forest"));// North

		// Added exit points
		// road
		Locations.get(1).addExit("W", 2);// Hill
		Locations.get(1).addExit("E", 3);// building
		Locations.get(1).addExit("S", 4);// vally
		Locations.get(1).addExit("N", 5);// forest
		// Locations.get(1).addExit("Q",0);// every location need this quit so
		// we can add it to
		// constructor so every location by default have this quit
		// Hill
		Locations.get(2).addExit("N", 5);// forest

		// Locations.get(2).addExit("Q",0);
		// building
		Locations.get(3).addExit("W", 1);
		// Locations.get(3).addExit("Q",0);

		// Vally
		Locations.get(4).addExit("N", 1);
		Locations.get(4).addExit("W", 2);
		// Locations.get(4).addExit("Q",0);
		// forest
		Locations.get(5).addExit("S", 1);
		Locations.get(5).addExit("W", 2);
		// Locations.get(5).addExit("Q",0);

		int loc = 1;
		while (true) {// infinit while loop which i m exiting when I press Q.
			System.out.println(Locations.get(loc).getDescription());
			if (loc == 0) {// press Q location becomes 0 will just end it break the game

				break;
			}
			Map<String, Integer> exits = Locations.get(loc).getExits();// creating
																		// all
																		// the
																		// available
																		// exits
																		// map/list
			System.out.println("Available exits are");// printing all the available exits
														
			for (String exit : exits.keySet()) {//looping through exit list (keyset)
				System.out.print(exit + ", ");
			}
			System.out.println();
			// before user input we printing all the available exits of previous input
			String direction = scanner.nextLine().toUpperCase();// user will add a direction such as N,S ,W waiting for input to press every time.

			String words[] = direction.split(" ");//Spliting user input the sentence will be devided into values

			for (String string : words) {//looping through the values
				if(Direction.getValue(string) != null || exits.containsKey(string) ) {//(Direction.getValue=!null) means if the the sentence doesn't have the value
					if (exits.containsKey(Direction.getValue(string))) {// check if has exit,based on whatever location(string is having the value in Direction map) i m giving its navigating.
						loc = exits.get(Direction.getValue(string));// if it allows it just goes to that direction
					}else if(exits.containsKey(string)) {//When user enter the letters only like Q,N,S,W,E no need to get value from Direction Class
						loc = exits.get(string);
					} else {
						System.out.println("You cannot go in that direction"); // otherwise it says u can't go in that direction
					}
				}
			}

			// before user input we printing all the available exits of previous
			// input
			/*
			 * if(exits.containsKey(direction)){//check if has exit,based on
			 * whatever location i m giving its navigating.
			 * loc=exits.get(direction);//if it allows it just goes to that
			 * direction }else{//otherwise it says u can't go in that direction
			 * System.out.println("You cannot go in that direction"); }
			 */

			/*
			 * loc= scanner.nextInt(); if(!Locations.containsKey(loc)){
			 * System.out.println("You cannot go in that direction");
			 */
		}
	}

	// String[]road="You are standing at the end of road".split(" ");
	// for(String s:road){
	// System.out.println(s);

}
