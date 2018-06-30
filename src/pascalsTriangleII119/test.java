package pascalsTriangleII119;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
		List<Integer> list = getRow(3);

		for(Integer n : list) {
			System.out.print(n + " ");
		}

	}
	
    public static List<Integer> getRow(int rowIndex) {    	
    	//O(k) space
    	List<Integer> list = new ArrayList<>();
    	int[] num = new int[rowIndex+1];
    	num[0] = 1;
    	for(int i=1; i<num.length; i++) {
    		for(int j=i; j>=1; j--) {
    			num[j] += num[j-1];
    		}   		
    	}
    	
    	for(int i=0; i<num.length; i++) {
    		list.add(num[i]);
    	}
    	return list;
    }
	
    /*
    public static List<Integer> getRow(int rowIndex) {

    	List<List<Integer>> list = new ArrayList<>();
    	
    	for(int i=1; i<=rowIndex+1; i++) {
    		List<Integer> subList = new ArrayList<>();
    		for(int j=1; j<=i; j++) {
    			if(j==1 || j==i) {
    				subList.add(1);
    			} else {
    				if(i > 2) {
    					subList.add(list.get(i-2).get(j-2) + list.get(i-2).get(j-1));
    				}
    			}   			
    		}
    		list.add(subList);
    	}       
        
        return list.get(list.size()-1);
    }
	*/
}

