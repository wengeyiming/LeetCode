package longestConsecutiveSequence128;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{100, 9,7,6,8,4, 200, 1, 3, 2, 11};
		System.out.println(longestConsecutive(nums));
	}
	
	/*
	//使用HashMap(本质上的思想还是union find)
    public static int longestConsecutive(int[] nums) {
        int res = 0;        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
        	if(!map.containsKey(n)) {
        		int left = map.containsKey(n-1) ? map.get(n-1) : 0;
        		int right = map.containsKey(n+1) ? map.get(n+1) : 0;
        		
        		int sum = left + right + 1;
        		map.put(n, sum);       		
        		res = Math.max(res, sum);
        		
        		map.put(n-left, sum);
        		map.put(n+right, sum);
        	} else {
        		continue;
        	}
        }
        
        return res;
    }
    */
	
    //使用union find(凡是找连通的问题都可以考虑使用该数据结构实现)
    public static int longestConsecutive(int[] nums) {
        UF uf = new UF(nums.length);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); // <value,index>
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            if(map.containsKey(nums[i]+1)){
                uf.union(map.get(nums[i]+1),i);
            }
            if(map.containsKey(nums[i]-1)){
                uf.union(map.get(nums[i]-1),i);
            }
        }
        return uf.maxUnion();
    }
}

class UF{
	//保存每个节点的根节点
    private int[] list;
    public UF(int n){
        list = new int[n];
        for(int i=0; i<n; i++){
            list[i] = i;
        }
    }
    
    private int root(int i){
        if(i != list[i]) {
        	return root(list[i]);
        } return i;
    }
    
    public boolean connected(int i, int j){
        return root(i) == root(j);
    }
    
    public void union(int p, int q){
      int i = root(p);
      int j = root(q);
      list[i] = j;
    }
    
    // returns the maxium size of union
    public int maxUnion(){ // O(n)
        int[] count = new int[list.length];
        int max = 0;
        for(int i=0; i<list.length; i++){
        	System.out.println(root(i));
            count[root(i)] ++;
            max = Math.max(max, count[root(i)]);
            
        }
        return max;
    }
}

