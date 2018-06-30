package mostProfitAssigningWork826;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) return -1;
                else if (a[0] < b[0]) return 1;
                else return b[1] - a[1];
            }
        });
    	
    	for(int i=0; i<profit.length; i++) {
    		pq.offer(new int[]{profit[i], difficulty[i]});
    	}
    	
    	Arrays.sort(worker);
    	int res = 0;
    	for(int i = worker.length-1; i>=0; i--) {
    		while(!pq.isEmpty() && worker[i] < pq.peek()[1]) pq.poll();
    		if(!pq.isEmpty()) {
    			res += pq.peek()[0];
    		}
    	}
    	return res;
    }   	
    	
    	/*PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] > b[0]) return -1;
                else if (a[0] < b[0]) return 1;
                else return b[1] - a[1];
            }
        });
        for (int i = 0; i < profit.length; i++) {
            pq.offer(new int[]{profit[i], difficulty[i]});
        }
        Arrays.sort(worker);
        int res = 0;
				// check workers ability, if it does not match, the next object in the pq will give next highest profit with less difficulty 
        for (int i = worker.length - 1; i >= 0; i--) {
            while (!pq.isEmpty() && worker[i] < pq.peek()[1]) pq.poll();
            if (!pq.isEmpty()) res += pq.peek()[0];
        }
        return res;
        */

}
