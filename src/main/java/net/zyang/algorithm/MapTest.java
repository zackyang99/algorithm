package net.zyang.algorithm;

import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapTest {

	public MapTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(1, 5);
		map.put(2, 10);
		map.put(5,  9);
		
		Entry<Integer, Integer> entry =  map.lastEntry();
		
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
	}

}
