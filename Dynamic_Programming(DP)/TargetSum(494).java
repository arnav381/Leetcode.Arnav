class Solution {
    int[][] dp = new int[21][2001];

    int fun (int i, int[] nums, int target, int sum){

        if (i >= nums.length){
            if (sum == target){
                return 1;
            }

            return 0;
        }

        if (dp[i][sum + 1000] != Integer.MIN_VALUE){
            return dp[i][sum + 1000];
        }

        int c1 = fun (i + 1, nums, target, sum - nums[i]);
        int c2 = fun (i + 1, nums, target, sum + nums[i]);

        return dp[i][sum + 1000] = c1 + c2;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        
        for (int i = 0; i < 21; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return fun (0, nums, target, 0);
    }
}