package bestTimetoBuyandSellStockIII123;

public class test {
	public static void main(String[] args) {
		int[] prices = new int[]{3,3,5,0,0,3,1,4};
		
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {    
	    int[] l = new int[3];
	    int[] g = new int[3];

	    
	    /*
		local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
		global[i][j] = max(local[i][j], global[i - 1][j])£¬
	    */
        for (int i = 0; i < prices.length - 1; ++i) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; --j) {
                l[j] = Math.max(g[j - 1] + Math.max(diff, 0), l[j] + diff);
                g[j] = Math.max(g[j], l[j]);
            }
        }
	    return g[2];   
	    
    }
	/*
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice < prices[i]) {
                left[i] = Math.max(left[i - 1], prices[i] - minPrice);
            } else {
                left[i] = left[i - 1];
                minPrice = prices[i];
            }
        }
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] < maxPrice) {
                right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
            } else {
                right[i] = right[i + 1];
                maxPrice = prices[i];
            }
        }
        for(int i=0; i<prices.length; i++) {
        	System.out.print(left[i] + " ");
        }
        System.out.println("");
        for(int i=0; i<prices.length; i++) {
        	System.out.print(right[i] + " ");
        }
        System.out.println("");
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
	*/

	/*
    public static int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
			
			System.out.println(buy1+","+sell1+","+buy2+","+sell2);
		}
		return sell2;
    }
    */
}
