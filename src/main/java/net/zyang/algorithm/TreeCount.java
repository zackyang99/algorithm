package net.zyang.algorithm;

public class TreeCount {
	int count = 0;
	int total = 6;

//	constructor
	public TreeCount(int total) {
		this.total = total;
	}
	
//	entry point
	public void run() {
		count(0, 1);
		display();
	}
	
//	recursive function to locate, and find max element in, sub-triangles
	public void count(int index, int row) {
//		stop recursion when out of array range
		if (index == -1) {
			return;
		}
		System.out.println((index+1) + " ");
		
		boolean canGoDown = true;
		int rowCopy = row;
		int lindex= index;
		int rindex = index;

		while (canGoDown) {
			int l = leftChildIndex(lindex, rowCopy);
			int r = rightChildIndex(rindex, rowCopy);
//			is a triangle if both left and right children exist
			if (l != -1 && r != -1) {
				System.out.println((l+1) + " " + (r+1));
				count = count + 1;
				lindex= l;
				rindex = r;
				++rowCopy;
			} else {
//				stop loop if any either left or right child not exist 
				canGoDown = false;
			}
		}
		
//		go to left child
		int lChildIndex = leftChildIndex(index, row);
		count(lChildIndex, row + 1);
		
//		go to right child only if last element of current row
//		to avoid duplicate iteration
		if (index + 1 == row*(row+1)/2) {
			int rChildIndex = rightChildIndex(index, row);
			count(rChildIndex, row + 1);
		}
	}
	
//	function to calculate left child index
	public int leftChildIndex(int index, int row) {
		int lChildIndex = index + row;
		
		return lChildIndex < total ? lChildIndex : -1;
	}
	
//	function to calculate right child index
	public int rightChildIndex(int index, int row) {
		int rChildIndex = index + row + 1;
		
		return rChildIndex < total ? rChildIndex : -1;
	}
	
//	function to display result
	public void display() {
		System.out.println("Count: " + count);
	}
	
	public static void main(String[] arg) {
		TreeCount tc = new TreeCount(1000);
		tc.run();
	}

}
