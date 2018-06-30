package superUglyNumber;


import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] primes = new int[]{2,7,13,19};
		System.out.println(nthSuperUglyNumber(12,primes));
	}
	
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n+1];
        int[] point = new int[primes.length];
                
        ugly[0] = 1;
        for(int i=1; i<n; i++) {
        	ugly[i] = Integer.MAX_VALUE;
        	for(int j=0; j<primes.length; j++) {
        		ugly[i] = Math.min(ugly[i], ugly[point[j]] * primes[j]);
        	}
        	
        	for(int j=0; j<primes.length; j++) {
        		while(primes[j] * ugly[point[j]] <= ugly[i]) point[j]++;
        	}
        }
    	
    	return ugly[n-1];
    }
}
