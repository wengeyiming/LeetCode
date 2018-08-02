package hIndex274;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] citations = new int[]{0,1};
		System.out.println(hIndex(citations));
	}
	
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int N = citations.length;
    	for(int h=0; h<N; h++) {
    		if(citations[h] >= N-h) {
    			return N-h;
    		}
    	}  	
	
    	return 0;
    }
}
