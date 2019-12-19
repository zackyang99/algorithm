package net.zyang.algorithm;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindConsecutiveSeq {

	public FindConsecutiveSeq() {
		// TODO Auto-generated constructor stub
	}
	
	public void convertToConsecutiveSequence(BigInteger n) {
		HashMap<Long, Long> factors = factor(n);
		Long powerOfFactorTwo = factors.get(2L);
		factors.remove(2L);
		
		List<HashMap<Long, Long>> oddFactorsMapList = getCombinations(factors);
		
		int totalWays = 0;
		
		for (int idx = 0; idx < oddFactorsMapList.size(); ++idx) {
			HashMap<Long, Long> currentFactorMap = oddFactorsMapList.get(idx);
			
//			sequence elements count if odd
			Long currentFactor = 1L;
			
			for (Long key : currentFactorMap.keySet()) {
				currentFactor *= Math.round(Math.pow(key, currentFactorMap.get(key)));
			}
			
			Long median = n.divide(BigInteger.valueOf(currentFactor)).longValue();
			
//			sequence elements count if iven
			Long evenMemberCount = 2 * currentFactor;
			
			if (median > currentFactor / 2) {
				++totalWays;
				for (int x = 0; x < currentFactor; ++x) {
					System.out.print(median - currentFactor / 2 + x + ",");
				}
				
				System.out.println("============================");
			}
			
		}
		
		System.out.println("Total ways: " + totalWays);
		
		
		
	}
	
	public HashMap<Long, Long> factor(BigInteger n) {
		HashMap<Long, Long> factors = new HashMap<Long, Long>();
		
		BigInteger leftOver = n;
		Long currentPrime = 2L;
		
		while (leftOver.compareTo(BigInteger.ONE) > 0) {
			if (isFactor(leftOver, currentPrime)) {
				if (!factors.containsKey(currentPrime)) {
					factors.put(currentPrime, 0L);
				}
				
				factors.put(currentPrime, factors.get(currentPrime) + 1);
				leftOver = leftOver.divide(BigInteger.valueOf(currentPrime));
			} else {
				currentPrime = findNextPrime(currentPrime);
			}
		}
		
		return factors;
	}
	
	public boolean isFactor(BigInteger dividend, Long divisor) {
		return dividend.mod(BigInteger.valueOf(divisor)).compareTo(BigInteger.ZERO) == 0;
	}
	
	public Long findNextPrime(Long current) {
		Long n=current;
		
		while(true) {
			n = n + 1;
			if(isPrime(n)) {
				break;
			}
		}
		
		return n;
	}
	
	public boolean isPrime(Long n) {
		for (Long f = 2L; f <= Math.sqrt(n); ++f) {
			if (n % f == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public List<HashMap<Long, Long>> getCombinations(HashMap<Long, Long> map) {
		Set<Long> keySet = map.keySet();
		List<HashMap<Long, Long>> list = null;
		
		if (keySet.size() == 1) {
			list = new ArrayList<HashMap<Long, Long>>();
			Long key = keySet.iterator().next();
			for (Long v = 0L; v <= map.get(key); ++v) {
				HashMap<Long, Long> current = new HashMap<Long, Long>();
				current.put(key,  v);
				list.add(current);
			}
			return list;
		} else {
			Long removedKey = keySet.iterator().next();
			Long removedKeyVal = map.get(removedKey);
			map.remove(removedKey);
			
			list = getCombinations(map);
			
			List<HashMap<Long, Long>> toBeAddedResults = new ArrayList<HashMap<Long, Long>>();
			for (int idx = 0; idx < list.size(); ++idx) {
				HashMap<Long, Long> idxMap = list.get(idx); 
				for (Long v = 1L; v <= removedKeyVal; ++v) {
					HashMap<Long, Long> idxMapWithNewKV = new HashMap<Long, Long>(idxMap);
					idxMapWithNewKV.put(removedKey, v);
					toBeAddedResults.add(idxMapWithNewKV);
				}
				idxMap.put(removedKey, 0L);
			}
			
			list.addAll(toBeAddedResults);
		}
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindConsecutiveSeq fcs = new FindConsecutiveSeq();
//		HashMap<Long, Long> factors = fcs.factor(BigInteger.valueOf(10 * Math.round(Math.pow(3, 10))));
//		
//		for (Long key : factors.keySet()) {
//			System.out.println("Factor " + key + ", power: " + factors.get(key));
//		}
//		
//		HashMap<Long, Long> m = new HashMap<Long,Long>(){{
//			put(3L, 5L);
//			put(5L, 6L);
//		}};
//		
//		List<HashMap<Long, Long>> list = fcs.getCombinations(m);
//		
//		for (int x = 0; x < list.size(); ++x) {
//			HashMap<Long, Long> map = list.get(x);
//			System.out.println("++++++++ List index" + x + "++++++++++++++");
//			for (Long y : map.keySet()) {
//				System.out.println("Key " + y + ": " + map.get(y));
//			}
//		}
		
		fcs.convertToConsecutiveSequence(BigInteger.valueOf(3*3*3*3*3*3*3L));

	}

}
