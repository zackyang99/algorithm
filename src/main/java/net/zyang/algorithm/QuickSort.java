package net.zyang.algorithm;

import java.util.Comparator;
import java.util.Random;

public class QuickSort {

	public QuickSort() {
		// TODO Auto-generated constructor stub
	}
	
	private static <T> void swap(T[] arr, int i, int j) { 
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	private static <T> void partition(T[] arr, int start, int end, Comparator<T> c) {
		int postion = end;
		for (int i = start; i <= end; ++i) {
			if (c.compare(arr[i], arr[postion]) <0) {
				if (i > postion) {
					int oldpostion = postion;
					swap(arr, i, postion);
					postion = i;
					if (oldpostion < end) {
						swap(arr, i, oldpostion + 1);
						postion = oldpostion + 1;
					}
				}
			} else {
				if (i < postion) {
					swap(arr, i, postion);
					postion = i;
				}
				
			}
		}
		
		
		
		if (postion > start + 1) partition(arr, start, postion - 1, c);
		if (postion < end - 1) partition(arr, postion + 1, end, c);
		
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		partition(arr, 0, arr.length - 1, c);
		
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Integer[] {100, 1000, 3, 5, 8, 2, 10, 6 , 7, 9, 100, 2000, 1000};
//		Integer[] arr = new Random().ints(100000, -100, 100 ).boxed().toArray(Integer[]::new);
		
		System.out.println("before sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		sort(arr, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		System.out.println("after sort");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}

}
