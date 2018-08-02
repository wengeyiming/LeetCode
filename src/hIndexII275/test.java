package hIndexII275;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] citations = new int[]{0};
		System.out.println(hIndex(citations));
	}
	
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int N = citations.length;
    	int left = 0, right = N-1;
    	while(left <= right) {
    		int mid = (left+right)/2;
    		if(citations[mid] == N-mid) return N-mid;
    		else if(citations[mid] > N-mid) right = mid-1;
    		else left = mid+1;
    	}
	
    	return N-right-1;
    }
}
