class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cheap = prices[0];

        for(int i=1;i<prices.length;i++) {
            if(cheap > prices[i]) {
                cheap = prices[i];
            }else if(prices[i] - cheap > profit) {
                profit = prices[i] - cheap;
            }
        }
        return profit;
    }
}