package topKFrequentWords692;

import java.util.*;

public class test {
	public static void main(String[] args) {
		String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"
				};
		List<String> list = topKFrequent(words, 2);
		for(String s : list) {
			System.out.print(s+" ");
		}
	}
	
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
        		(a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        		);

        Map<String, Integer> map = new HashMap<>();
        for(String s : words) {
        	map.put(s, map.getOrDefault(s, 0)+1);
        }

    	
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
        	queue.offer(entry);
        	if(queue.size() > k) queue.poll();
        }
        
        while(!queue.isEmpty()) {
        	res.add(0, queue.poll().getKey());
        }
    	return res;
    }
}
