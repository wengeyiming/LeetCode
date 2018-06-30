package bestTimetoBuyandSellStock121;

public class test {
	public static void main(String[] args) {
		int[] prices = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
	
    public static int maxProfit(int[] prices) {
        int price = 0;
        int max = 0;
        for(int i=0; i<prices.length-1; i++) {
        	int dif = prices[i+1] - prices[i];
        	price += dif;
        	if(dif >= 0) {       		
        		if(price > max) {
        			max = price;
        		}
        	} else {
        		if(price < 0) {
        			price = 0;
        		}
        	}
        }
        
        return max;
    }
}
