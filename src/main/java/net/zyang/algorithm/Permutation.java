package net.zyang.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public Permutation() {
		// TODO Auto-generated constructor stub
	}
	
	public static <E> void permute(List<E> list, int position) {
		if (position == list.size() - 1 ) {
			System.out.println(list);
		}
		
		for (int i = position; i < list.size(); ++i) {
			swap(list, position, i);
			permute(list, position + 1);
			swap(list, i, position);
		}
	}
	
	private static <E> void swap(List<E> l, int i, int j) {
		E a = l.get(i);
		l.set(i, l.get(j));
		l.set(j, a);
	}
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>() {{
			add("A");
			add("B");
			add("C");
			add("D");
			add("E");
			add("F");
			add("G");
			add("H");
			add("I");
			add("J");
			add("K");
			add("L");
			add("M");
			add("N");
		}};
		
		permute(l, 0);
	}

}
