package pascalsTriangle118;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
		List<List<Integer>> list = generate(5);
		for(List<Integer> subList : list) {
			for(Integer n : subList) {
				System.out.print(n + " ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> list = new ArrayList<>();
    	
    	for(int i=1; i<=numRows; i++) {
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
    	
    	return list;
    }
}
