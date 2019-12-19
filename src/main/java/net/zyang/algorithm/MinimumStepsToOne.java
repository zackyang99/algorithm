package net.zyang.algorithm;

public class MinimumStepsToOne {
	int number;
	
	public MinimumStepsToOne(int number) {
		this.number = number;
	}
	
	public void work() {
		int[] steps = new int[number + 1];
		steps[0] = 0;
		steps[1] = 0;
		
		for (int i = 2; i <= number; ++i ) {
			int minRequired = steps[i - 1] + 1;
			
			if (i % 3 == 0) {
				int viaDivideBy3 = steps[i / 3] + 1;
				
				if (viaDivideBy3 < minRequired) {
					minRequired = viaDivideBy3;
				}
			}
			
			if (i % 2 == 0) {
				int viaDivideBy2 = steps[i / 2] + 1;
				if (viaDivideBy2 < minRequired) {
					minRequired = viaDivideBy2;
				}
			} 
			
			steps[i] = minRequired;
		}
		
		for (int n : steps) {
			System.out.print(n + ", ");	
		}
		System.out.println();
		System.out.println(steps[number]);	

	}
	
	public static void main(String[] args) {
		MinimumStepsToOne mso = new MinimumStepsToOne(7);
		mso.work();
	}

}
