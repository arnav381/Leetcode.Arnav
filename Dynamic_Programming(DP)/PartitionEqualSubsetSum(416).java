class Solution {
    int[][] dp;

    int fun (int i, int[] nums, int target){

        if (i >= nums.length || target < 0){
            return 0;
        }

        if (target == 0){
            return 1;
        }

        if (dp[i][target] != -1){
            return dp[i][target];
        }

        int take = fun (i + 1, nums, target - nums[i]);
        int skip = fun (i + 1, nums, target);

        dp[i][target] = (take == 1 || skip == 1)? 1 : 0;
        return dp[i][target];
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if (sum % 2 != 0){
            return false;
        }

        int target = sum / 2;

        dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return fun (0, nums, target) == 1;
    }
}