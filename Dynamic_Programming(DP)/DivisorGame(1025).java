class Solution {
    int[] dp;
    public boolean fun(int n) {
        if (n == 1) {
            return false;
        }
        if (dp[n] != 0){
            return dp[n] == 1;
        }
        for (int x = 1; x < n; x++) {
            if (n % x == 0) {
                if (!fun(n - x)) {
                    dp[n] = 1;
                    return true;
                }
            }
        }
        dp[n] = -1;
        return false;
    }
    public boolean divisorGame(int n) {
        dp = new int[n+1];
        return fun(n);
    }
}