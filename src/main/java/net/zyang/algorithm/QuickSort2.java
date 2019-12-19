package net.zyang.algorithm;

import java.util.Comparator;
import java.util.Random;

public class QuickSort2 {

	public QuickSort2() {
		// TODO Auto-generated constructor stub
	}
	
	private static <T> void swap(T[] arr, int i, int j) { 
		T t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	private static <T> int partition(T[] arr, int low, int high, Comparator<T> c) {
		T pivot = arr[high];
		
		int i = low - 1;
		
		for (int j = low; j < high; ++j) {
			if (c.compare(arr[j], pivot) < 0) {
				++i;
				
				if (i != j) {
					swap(arr, i, j);
				}
			}	
		}
		
		swap(arr, i + 1, high);
		return  i + 1;
	}
	
	private static<T> void quickSort(T[] arr, int low, int high, Comparator<T> c) {
		int pi = -1;
		
		if (low < high) {
			pi = partition(arr, low, high, c);
			
			quickSort(arr, low, pi - 1, c);
			quickSort(arr, pi + 1, high, c);
		}
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
		quickSort(arr, 0, arr.length - 1, c);
	}
	
	public static void main(String[] args) {
		Integer[] arr = new Random().ints(10000, -1000, 1000).boxed().toArray(Integer[]::new);
		
		
		System.out.println("before sort");
		display(arr);
		sort(arr, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
			
		});
		
		System.out.println("after sort");
		display(arr);
		System.out.println();
		
	}

}
