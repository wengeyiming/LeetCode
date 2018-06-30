package gasStation134;

public class test {
	public static void main(String[] args) {
		int[] gas = new int[]{1,2,3,4,5};
		int[] cost = new int[]{3,4,5,1,2};		
		System.out.println(canCompleteCircuit(gas, cost));
	}
	
	
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	
    	int gAmount = 0;
    	int cAmount = 0;
    	for(int i=0; i<gas.length; i++) {
    		gAmount += gas[i];
    		cAmount += cost[i];
    	}    	
    	if(gAmount < cAmount || gAmount == 0) return -1;
     	
    	int[] left = new int[gas.length];
    	for(int i=0; i<left.length; i++) {
    		left[i] = gas[i] - cost[i];
    	}
    	int sum = 0, start = 0, total = 0;
    	for(int i=0; i<left.length; i++) {
    		total += left[i];
    		if(sum < 0) {
    			start = i;
    			sum = left[i];
    		} else {
    			sum = sum + left[i];
    		}
    	}
    	
        return total < 0 ? -1 : start;
    }
}
