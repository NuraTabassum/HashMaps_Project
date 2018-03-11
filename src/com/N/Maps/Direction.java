package com.N.Maps;

import java.util.HashMap;
import java.util.Map;

public class Direction {
	static Map<String, String> direction = new HashMap() {
		{
			put("EAST", "E");
			put("WEST", "W");
			put("NORTH", "N");
			put("SOUTH", "S");
		}
	};
	
	public static String getValue(String val) {
		return direction.get(val);
	}
	
}
