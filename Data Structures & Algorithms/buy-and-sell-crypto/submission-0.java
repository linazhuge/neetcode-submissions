class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int x : prices) {
            if (x < min) min = x;
            if ((x - min) > maxProfit) maxProfit = x - min;
        }

        return maxProfit;
    }
}
