class Solution {
    int[] dp;
    int fun (int[] nums, int i){

        if (i == 0){
            return nums[0];
        }
        if (dp[i] != Integer.MIN_VALUE){
            return dp[i];
        }

        return dp[i] = Math.max(nums[i], fun (nums, i - 1) + nums[i]);
    }
    public int maxSubArray(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, fun (nums, i));
        }

        return max;
    }
}