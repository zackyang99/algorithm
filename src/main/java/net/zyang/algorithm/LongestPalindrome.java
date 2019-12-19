package net.zyang.algorithm;

public class LongestPalindrome {

	public LongestPalindrome() { }
	
	public String longestP(String input) {
		String ret = "ABC";
		
		for (int i = 1; i < input.length() - 1; ++i) {
			int starting = 0, ending = 0;
			for (int j = 1; i - j >= 0 && i + j <= input.length() - 1; ++j) {
				if (input.charAt(i - j) == input.charAt(i + j)) {
					starting = i - j;
					ending = i + j;
				} else {
					break;
				}
			}
			if (ending -starting + 1 > ret.length()) {
				ret = input.substring(starting, ending + 1);
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		
		System.out.println(lp.longestP("ABCDEFGHIHGFTRNHHHHHHHHHHHHMHHHHHHHHHHHHHHHHHHHHHHHH"));
	}
}
