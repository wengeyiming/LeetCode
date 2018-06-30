package combinations77;


import java.util.*;
public class test {
	public static void main(String[] args) {
		List<List<Integer>> list = combine(5,2);		
		for(List<Integer> subList : list) {
			for(Integer n : subList) {
				System.out.print(n+" ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();   
        findByBackTracking(list, subList, n, k, 0, 1);
        return list;
    }
    
    public static void findByBackTracking(List<List<Integer>> list, List<Integer> subList, int n, int k, 
    		int nowLength, int now) {
    	if(nowLength == k) {
    		list.add(new ArrayList<>(subList));
    		return;
    	}
    	
    	for(int i=now; i<=n; i++) {
    		subList.add(i);
    		findByBackTracking(list,subList,n,k,nowLength+1,i+1);
    		subList.remove(subList.size()-1);
    	}
    }
}
