package net.zyang.algorithm;

public class RollingHash {
	long base = 256;
	long mod = 101;

	public RollingHash() {}
	
	public long rolling(String str1, String str2, long oldhash) {
		if (str1 == null) {
			long ret = 0;
			
			for (int index = 0; index < str2.length(); ++index) {
				ret = (ret * base + (long)str2.charAt(index)) % 101;
			}
			
			return ret;
		} else {
			long first = 1;
			for (int i = 0; i < str1.length() - 1; ++i) {
				first = (first * base) % 101;
			}
			
			return (oldhash - first + (long)str2.charAt(str2.length() - 1)) % 101;
			
		}
			
	}
	
	public static void main(String[] args) {
		RollingHash rh = new RollingHash();
		
		
		String strA = "ABCDEFGHIJKLMN";
		String strB = "ABCDEFGHI";
		
		
		int x = strB.length() / 2;
		
		
		String previousB = null;
		String currentB = null;
		long oldhashB = 0;
		long newhashB = 0;
		
		String previousA = null;
		String currentA = null;
		long oldhashA = 0;
		long newhashA = 0;
		
		for (int i = 0; i < strB.length() - x; ++i) {
			currentB = strB.substring(i, i + x);
			newhashB = rh.rolling(previousB, currentB, oldhashB);
			
			for (int j = 0; j < strA.length() - x; ++j) {
				currentA = strA.substring(j, j + x);
				newhashA = rh.rolling(previousA, currentA, oldhashA);
				
				if (newhashA == newhashB) {
					System.out.println(strA.substring(j, j + x));
					System.out.println(strB.substring(i, i + x));
					System.out.println(newhashA);
					System.out.println(newhashB);
				}
				
				previousA = currentA;
				oldhashA = newhashA;
				
			}
			
			previousB = currentB;
			oldhashB = newhashB;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
