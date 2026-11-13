class Solution {
    int[] dp;

    int fun (int i, int n){

        if (i >= n){
            return 1;
        }

        if (dp[i] != -1){
            return dp[i];
        }

        int place = fun (i + 2, n);
        int notPlace = fun (i + 1, n);

        return dp[i] = (place + notPlace) % 1000000007;
    }

    public int countHousePlacements(int n) {

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = fun (0, n);
        return (int)((1L * ans * ans) % 1000000007);
        
    }
}