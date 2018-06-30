package fourSumTwo454;
import java.util.*;

//这个题要求结果为zero，如果为其他值会如何？
//注意将四重循环分为两个二重循环的思想.
public class test {
	public static void main(String[] args) {
		int[] A = new int[]{1,2};
		int[] B = new int[]{-2,-1};
		int[] C = new int[]{-1,2};
		int[] D = new int[]{0,2};
		
		System.out.println(fourSumCount(A,B,C,D));		
	}
	
	
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	
    	int res = 0;
    	for(int i=0; i<A.length; i++) {
    		for(int j=0; j<B.length;j++) {
    			map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j], 0)+1);
    		}
    	}
    	
    	for(int k=0; k<C.length; k++) {
    		for(int m=0; m<D.length; m++) {
    			res += map.getOrDefault(-1*(C[k]+D[m]),0);
    		}
    	}
    	
    	
        return res;
    }
}
