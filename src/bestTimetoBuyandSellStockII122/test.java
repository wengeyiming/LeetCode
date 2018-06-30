package bestTimetoBuyandSellStockII122;

public class test {
	public static void main(String[] args) {
		int[] prices = new int[]{1,5,3,7,6};
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {
    	int max = 0;
        for(int i=0; i<prices.length-1; i++) {
        	if(prices[i] < prices[i+1]) {
        		max = max + prices[i+1] - prices[i];
        	}
        }
        
        return max;
    }
}
