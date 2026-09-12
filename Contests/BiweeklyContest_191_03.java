class Solution {
    int dp[];
    int fun (int n){
        if (n == 0){
            return 0;
        }
        if (dp[n] != -1){
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i*(i+1)/2 <= n; i++){
            int score = i*(i+1)/2;
            int x = fun(n - score);
            int days = i+x;
            if (n-score > 0){
                days++;
            }
            ans = Math.min(ans, days);
        }
        return dp[n] = ans;    
    }
    public int minDays(int n) {
        dp = new int[n+1];
        for (int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        return fun (n);       
    }
}