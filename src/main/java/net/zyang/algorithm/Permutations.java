package net.zyang.algorithm;

public class Permutations {
	final int SIZE = 3;
	char[] seq = new char[] {'A', 'B', 'C'};

	public Permutations() {
		// TODO Auto-generated constructor stub
	}
	
	public void swap(char[] seq, int x, int y) {
		char temp = seq[x];
		seq[x] = seq[y];
		seq[y] = temp;
	}
	
	public void work(char[] seq, int start) {
		if (start < seq.length) {
			for (int i = start; i < seq.length; ++i) {
				if (i == start) {
					for (char c : seq) {
						System.out.print(c + ", ");
					}
					System.out.println();
				} else {
					char[] seqCopy = new char[seq.length];
					System.arraycopy(seq, 0, seqCopy, 0, seq.length);
					swap(seqCopy, start, i);
					work(seqCopy, start + 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		p.work(p.seq, 0);
	}

}
