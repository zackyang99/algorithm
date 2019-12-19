package net.zyang.algorithm;

import java.math.BigDecimal;

import org.nevec.rjm.BigDecimalMath;

public class RecursiveLimit {

	public RecursiveLimit() {
		// TODO Auto-generated constructor stub
	}
	
	public static BigDecimal work(int n) {
		BigDecimal ret = new BigDecimal(1);
		BigDecimal e = new BigDecimal(Math.E);
		BigDecimal negativeOne = new BigDecimal(-1);
		
		while(n > 0) {
			ret = ret.add(BigDecimalMath.pow(e, ret.multiply(negativeOne)));
			--n;
		}
		
		return ret;
	}
	
	public static double workDouble(long n) {
		double ret = 1;
		
		while(n > 0) {
			ret = ret + Math.pow(Math.E, ret*(-1));
			--n;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(workDouble(2000000L)/(Math.log(2000000)));
	}

}
