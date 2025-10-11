public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int b = 0;
        for (int s = 1; s < prices.length && b < prices.length; s++) {
            if (prices[s] > prices[b]) {
                maxProfit = Math.max(prices[s] - prices[b], maxProfit);
            } else {
                b = s;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit.maxProfit(prices));
        int[] prices2 = {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(maxProfit.maxProfit(prices2));
    }
}
