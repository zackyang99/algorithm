package net.zyang.algorithm;

import java.math.BigDecimal;
import java.math.MathContext;

public class NestedRadical {
	
	public NestedRadical() {
		// TODO Auto-generated constructor stub
	}
	
	public static BigDecimal work(int n, BigDecimal x) {
		BigDecimal ret = x.pow(n);
		
		while (n > 0) {
			ret = (ret.add(x.pow(n - 1))).sqrt(MathContext.DECIMAL128);
			--n;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(work(1000, new BigDecimal(4)));
		
	}

}
