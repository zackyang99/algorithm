package net.zyang.algorithm;

import java.net.StandardSocketOptions;

public class Queen {
	private final int SIZE = 10;
	private int[][] board = new int[SIZE][SIZE];
	
	public Queen() { }
	
	public boolean isAttacked(int[][] board, int x, int y) {
		boolean ret = false;
		
		for (int i = 0; i < SIZE; ++i) {
			if (board[i][y] == 1) {
				return true;
			}
		}
		
		for (int j = 0; j < SIZE; ++j) {
			if (board[x][j] == 1) {
				return true;
			}
		}
		
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (board[i][j] == 1 && ((i + j) == (x + y) || (i - j) == (x - y))) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public int[][] arrayCopy(int[][] original) {
		int[][] copy = new int[original.length][];
		for (int i = 0; i < original.length; ++i) {
			copy[i] = new int[original[i].length];
			System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
		}
		
		return copy;
	}
	
	public boolean put(int[][] board, int n) {
		if (n == 0) {
			return true;
		}
		
		for (int i = 0; i < SIZE; ++i) {
			for (int j = 0; j < SIZE; ++j) {
				if (!isAttacked(board, i, j)) {
					board[i][j] = 1;
					if (put(board, n - 1)) {
						return true;
					} else {
						board[i][j] = 0;
					}
				}
			}
		}
		
		return false;
	}
	
	
	public static void main(String args[]) {
		Queen queen = new Queen();
		boolean ret = queen.put(queen.board, queen.SIZE);
		if (!ret) {
			System.out.println("no solution");
		}
		
		for (int i =0 ; i < queen.SIZE; ++i) {
			for (int j = 0; j < queen.SIZE; ++j) {
				System.out.print(queen.board[i][j] + ",");
			}
			System.out.println();
			
		}
		
	}

}
