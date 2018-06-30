package topKFrequentElements347;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,3};
		List<Integer> list = topKFrequent(nums,2);
		for(Integer n : list) {
			System.out.print(n+" ");
		}
		
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}
		
		List<Integer>[] bucket = new ArrayList[nums.length+1];
		for(int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			//����List�����ʱ��һ��Ҫע���������Ԫ�ؿ�ʼ���Ƿǿյģ�����Ҫ����null����ж�
			if(bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();			
			}
			bucket[frequency].add(key);
		}
		
		List<Integer> res = new ArrayList<>();
		
		for(int i=bucket.length-1; i>=0; i--) {
			if(bucket[i] != null) {
				k = k-bucket[i].size();
				res.addAll(bucket[i]);				
				if(k <= 0) {
					break;
				}
			}
		}	
		

		return res;

	}
}
