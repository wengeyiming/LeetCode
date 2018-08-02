package wordLadderII126;

import java.util.*;

public class test {
	public static void main(String[] args) {
		String beginWord = new String("hit");
		String endWord = new String("cog");
		List<String> wordList = new ArrayList<>();
		wordList.add(new String("hot"));
		wordList.add(new String("dot"));
		wordList.add(new String("dog"));
		wordList.add(new String("lot"));
		wordList.add(new String("log"));
		wordList.add(new String("cog"));
		
		List<List<String>> res = findLadders(beginWord, endWord, wordList);
		for(List<String> subList : res) {
			for(String s : subList) {
				System.out.print(s+" ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord); 
        if (!wordSet.contains(endWord)) {
            return res;
        }
        List<String> path = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        bfsToBuildGraph(graph, dist, beginWord, endWord, wordSet);
        dfsToFindShortestPath(res, path, beginWord, endWord,dist, graph);
        return res;
    }
    
    //利用BFS构造图的邻接列表(adjacency list)表示形式
    private static void bfsToBuildGraph(Map<String, List<String>> graph, Map<String, Integer> dist,
    		String beginWord, String endWord, Set<String> wordSet) {
    	Queue<String> queue = new LinkedList<>();
    	queue.offer(beginWord);
    	dist.put(beginWord, 0);
    	for(String s : wordSet) {
    		graph.put(s, new ArrayList<>());
    	}
    	while(!queue.isEmpty()) {   		
    		String s = queue.poll();
    		//System.out.println("s: " + s);
    		List<String> neighbors = getNeighbors(s, wordSet);  
    		for(String neighbor : neighbors) {
    			graph.get(neighbor).add(s);
    			if(!dist.containsKey(neighbor)) {
    				dist.put(neighbor, dist.get(s)+1);
    				queue.offer(neighbor);
    			}
    		}
    	}
    }
    
    
    //利用DFS从开始到结束寻找最短路径
    private static void dfsToFindShortestPath(List<List<String>> res, List<String> path, String beginWord,
    		String endWord, Map<String, Integer> dist, Map<String, List<String>> graph) {
    	if (endWord.equals(beginWord)) {
            path.add(endWord);
            res.add(new ArrayList<String>(path));
            path.remove(path.size()-1);
            return;
        }
    	
    	
    	for(String neighbor : graph.get(beginWord)) {
    		if(dist.containsKey(neighbor) && dist.get(beginWord)+1 == dist.get(neighbor)) {
    			path.add(beginWord);
    			dfsToFindShortestPath(res, path, neighbor, endWord, dist, graph);
    			path.remove(path.size()-1);
    		}
    		
    	}    	
    }
    
    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<String>();      
        for(int i=0; i<word.length(); i++) {
        	for(char j='a'; j<='z'; j++) {
        		char[] chs = word.toCharArray();
        		if(j != chs[i]) {
        			chs[i] = j;
        			String ss = new String(chs);
        			if(wordSet.contains(ss)) {
        				res.add(ss);
        			}
        		}       		
        	}
        }                
        return res;
    }
    
    /*
    //利用DFS从结束到开始寻找最短路径
    private static void dfsToFindShortestPath(List<List<String>> res, List<String> path, String beginWord,
    		String endWord, Map<String, Integer> dist, Map<String, List<String>> graph) {
    	if (endWord.equals(beginWord)) {
            path.add(0, endWord);
            res.add(new ArrayList<String>(path));
            path.remove(0);
            return;
        }
    	
    	for(String neighbor : graph.get(endWord)) {
    		if(dist.containsKey(neighbor) && dist.get(endWord) == dist.get(neighbor) + 1) {
    			path.add(0,endWord);
    			dfsToFindShortestPath(res, path, beginWord, neighbor, dist, graph);
                path.remove(0);
    		}
    		
    	}    	
    }
    */
}



//System.out.println("hit: " + graph.get("hit"));
//System.out.println("hot: " + graph.get("hot"));
//System.out.println("lot: " + graph.get("lot"));
//System.out.println("dot: " + graph.get("dot"));
// System.out.println("log: " + graph.get("log"));
// System.out.println("dog: " + graph.get("dog"));
// System.out.println("cog: " + graph.get("cog"));


//System.out.println();

//System.out.println("hit: " + dist.get("hit"));
//System.out.println("hot: " + dist.get("hot"));
//System.out.println("lot: " + dist.get("lot"));
//System.out.println("dot: " + dist.get("dot"));
// System.out.println("log: " + dist.get("log"));
// System.out.println("dog: " + dist.get("dog"));
// System.out.println("cog: " + dist.get("cog"));
