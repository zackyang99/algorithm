package net.zyang.algorithm;

import java.math.BigInteger;

public class Remainder {

	public Remainder() {
		// TODO Auto-generated constructor stub
	}
	
	public static BigInteger remainder(BigInteger base, long exponent, BigInteger divisor) {
		BigInteger temp = base.mod(divisor);
		
		while (exponent > 1) {
			temp = temp.multiply(base).mod(divisor);
			exponent = exponent - 1;
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		BigInteger base = BigInteger.TEN;
		long exponent = 200;
		BigInteger divisor = BigInteger.valueOf(7);
		
		BigInteger r = remainder(base, exponent, divisor);
		System.out.println(r);
	}

}
