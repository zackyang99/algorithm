package net.zyang.algorithm;

import java.util.Comparator;
import java.util.Random;

public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}
	
	private static <T> void swap(T[] arr, int i, int j) { 
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	private static <T> void merge(T[] arr, Comparator<T> c, int ls, int le, int rs, int re) {
		for (int i = rs; i <= re; ++i) {
			for (int j = i - 1; j >= ls; --j) {
				if (c.compare(arr[j], arr[j+1]) > 0) {
					swap(arr, j, j+1);
				} else {
					break;
				}
			}
		}
	}
	
	private static <T> void mergeSort(T[] arr, Comparator<T> c, int start, int end) {
		int half = (start + end) / 2;
		
		if (half > start) {
			mergeSort(arr, c, start, half);
		}
		
		if (end > half + 1) {
			mergeSort(arr, c, half+1, end);
		}
		
		merge(arr, c, start, half, half + 1, end);
	}
	
	private static<T> void display(T[] arr) { 
		System.out.println("---------------------------------------");
		for (T t : arr) {
			System.out.print(t + " ");
		}
		System.out.println();
		System.out.println("---------------------------------------");
	}
	
	public static<T> void sort(T[] arr, Comparator<T> c) {
		mergeSort(arr, c, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Random().ints(100000, -1000, 1000).boxed().toArray(Integer[]::new);
		
		
		System.out.println("before sort");
		display(arr);
		sort(arr, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
		
		System.out.println("after sort");
		display(arr);
		System.out.println();
		
	}

}
