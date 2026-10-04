class Solution {
    long[][][] dp;
    long fun (int i, int a, int b, int[] nums){
        if (i == nums.length){
            return 0;
        }
        if (dp[i][a][b] != Long.MIN_VALUE){
            return dp[i][a][b];
        }
        
        long val;
        if (a == 0){
            val = nums[i];
        } else {
            val = -nums[i];
        }
        long take = val;
        if (i + 1 < nums.length){
            take = Math.max(take, val + fun (i + 1, 1 - a, b, nums));
        }
        
        long del = Long.MIN_VALUE / 2;
        if (b == 0){
            del = fun (i + 1, a, 1, nums);
        }
        
        return dp[i][a][b] = Math.max(take, del);
    }
    
    public long maxAlternatingSum(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        
        dp = new long[nums.length][2][2];
        
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < 2; j++){
                for (int k = 0; k < 2; k++){
                    dp[i][j][k] = Long.MIN_VALUE;
                }
            }
        }
        
        long ans = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            long takeFirst = nums[i];
            
            if (i + 1 < nums.length){
                takeFirst += Math.max(0, fun (i + 1, 1, 0, nums));
            }
            ans = Math.max(ans, takeFirst);

            if (i + 1 < nums.length){
                ans = Math.max(ans, fun (i + 1, 0, 1, nums));
            }
        }
        return ans;
    }
}