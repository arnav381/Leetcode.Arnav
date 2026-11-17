class Solution {
    long[][] dp;

    long fun (int i, int flag, int[] nums){

        if (i >= nums.length){
            return 0;
        }

        if (dp[i][flag] != -1){
            return dp[i][flag];
        }

        long take = 0;
        if (flag == 0){
            take = nums[i] + fun (i + 1, 1, nums);
        }

        else {
            take = -nums[i] + fun (i + 1, 0, nums);
        }

        long skip = fun (i + 1, flag, nums);
        return dp[i][flag] = Math.max(take, skip);
    }

    public long maxAlternatingSum(int[] nums) {

        dp = new long[nums.length][2];
        for (int i = 0; i < nums.length; i++){

            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return fun (0, 0, nums);
    }
}