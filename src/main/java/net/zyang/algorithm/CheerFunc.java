package net.zyang.algorithm;

import java.util.HashMap;
import java.util.Map;

public class CheerFunc {
	Map<Integer, Integer> track = new HashMap<Integer, Integer>();	
	int largest = 0;
	
	public void calculate(int input) {
		int current;
		
		for (int n = 1; n <= input; ++n) {
			if (n == 1) {
				current = 1;
			} else if (n % 2 == 0) {
				current = track.get(n/2);
			} else {
				current = track.get(n/2) + 1;
			}
			
			track.put(n, current);
			
			if (current > largest) {
				largest = current;
			}
		}
	}
	
    public static void main( String[] args ) {
    	CheerFunc cheerFunc = new CheerFunc();
    	cheerFunc.calculate(1994);
        System.out.println( cheerFunc.largest );
    }
}
