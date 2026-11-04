class Solution {
    
    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = nums[0];
        
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for (int i = 2; i < n; i++){

            int c1 = nums[i] + dp[i - 2][0];
            int c2 = dp[i - 1][0];

            dp[i][0] = Math.max(c1, c2);

            int c3 = nums[i] + dp[i - 2][1];
            int c4 = dp[i - 1][1];

            dp[i][1] = Math.max(c3, c4);
        }

        return Math.max(dp[n - 1][0], dp[n - 2][1]);
    }
}