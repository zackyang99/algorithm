package net.zyang.algorithm;

import java.util.Random;

public class ThreeCoin {
	int n = 100;
	Random r = new Random();
	char[][] coins = new char[3][2];
	
	public ThreeCoin() {		
		this.coins[0][0] = 'R';
		this.coins[0][1] = 'R';
		this.coins[1][0] = 'B';
		this.coins[1][1] = 'B';
		this.coins[2][0] = 'R';
		this.coins[2][1] = 'B';
	}
	
	public void setNumberOfExperiment(int n) {
		this.n= n;
	}
	
	public void work() {
		int success = 0;
		for (int i = 1; i <= n; ++i) {
			if (experiment(i)) ++success;
		}
		
		System.out.println("Win rate: " + (success * 1.0 / n));
	}
	
	public boolean experiment(int i) {
		int idxOfCoin = r.nextInt(3);
		int idxOfTop = r.nextInt(2);
		int idxOfBottom = idxOfTop == 0 ? 1 : 0; 
		
		char colorOfTop = this.coins[idxOfCoin][idxOfTop];
		char colorOfBottom = this.coins[idxOfCoin][idxOfBottom];
		boolean success = (colorOfTop == colorOfBottom);
		display(i, colorOfTop, colorOfBottom, success);
		
		return success;
	}
	
	public void display(int experimentNo, char topColor, char bottomColor, boolean success) {
		System.out.format("Experiment #: %8d | Color of Top: %c | Color of Bottom: %c | Color guessed: %c | Win: %-3s%n", experimentNo, topColor, bottomColor, topColor, (success ? "Yes" : "No"));
		
	}
	
	public static void main(String[] args) {
		ThreeCoin tc = new ThreeCoin();
		tc.setNumberOfExperiment(100000);
		tc.work();
	}
}




































































