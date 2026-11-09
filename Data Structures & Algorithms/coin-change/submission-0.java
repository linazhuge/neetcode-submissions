class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        int [] numCoins = new int[amount + 1];

        for (int i=0; i <= amount; i++) {
            numCoins[i] = -1;
            for (int j=0; j < coins.length; j++) {
                if (i - coins[j] < 0) break;
                if (i == coins[j]) {
                    numCoins[i] = 1;
                    break;
                }
                if (numCoins[i - coins[j]] == -1) continue;
                if (numCoins[i] == -1) numCoins[i] = numCoins[i - coins[j]] + 1;
                else numCoins[i] = Math.min(numCoins[i], numCoins[i - coins[j]] + 1);
            }
        }

        return numCoins[amount];
    }
}
