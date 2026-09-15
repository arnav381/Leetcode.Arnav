class Solution {
    int [][] dp = new int[10005][15];
    int fun (int[] coins, int amount, int i){
        if (amount == 0){
            return 0;
        }
        if (amount < 0 || i >= coins.length){
            return Integer.MAX_VALUE;
        }
        if (dp[amount][i] != -1){
            return dp[amount][i];
        }
        int min = Integer.MAX_VALUE;
        int c1 = fun (coins, amount - coins[i], i);
        int c2 = fun (coins, amount, i+1);
        if (c1 != Integer.MAX_VALUE){
            c1 = 1 + c1;
        }
        return dp[amount][i] = Math.min(c1, c2);
    }
    public int coinChange(int[] coins, int amount) {
        for (int i = 0; i < 10005; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = fun (coins, amount, 0);
        if (ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}