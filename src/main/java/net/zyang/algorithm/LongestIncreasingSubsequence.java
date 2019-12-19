package net.zyang.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubsequence {
	List<Integer> list = new ArrayList<Integer>();
	
	//track will store longest subsequence whose largest element equals the map key
	Map<Integer, List<Integer>> track = new HashMap<Integer, List<Integer>>();

	public LongestIncreasingSubsequence(List list) {
		this.list = list;
	}
	
	public void work() {
		for (int i = 0; i < list.size(); ++i) {
			//current number in the list
			int n = list.get(i);
			//length of longest sub sequence in current map
			int longestLength = 0;
			//key of the longest sub sequence in current map
			int longestKey = n;
			
			
			//looking for the longest subsequence whose key is less than current number n
			for (Integer k : track.keySet()) {
				if (k < n) {
					if (track.get(k).size() > longestLength) {
						longestLength = track.get(k).size();
						longestKey = k;
					}
				}
			}
			
			//if key not exist yet
			if (longestKey != n) {
				if (!track.containsKey(n) || track.get(n).size() < track.get(longestKey).size() + 1) {
					ArrayList<Integer> newlist = new ArrayList<Integer>(track.get(longestKey));
					newlist.add(n);
					track.put(n, newlist);
				}	
			} else {
				ArrayList<Integer> newlist = new ArrayList<Integer>();
				newlist.add(n);
				track.put(n, newlist);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 4, 1, 5, 9, 3, 10, 34, 100, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 201, 202, 203, 204, 204, 204, 208, 209, 15, 18, 19, 20, 89, 90, 205);
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(list);
		lis.work();
		
		for (Integer k : lis.track.keySet()) {
			List l = lis.track.get(k);
			for (int i = 0 ; i < l.size(); ++i) {
				System.out.print(l.get(i) + ", ");
			}
			System.out.println();
		}
	}

}
