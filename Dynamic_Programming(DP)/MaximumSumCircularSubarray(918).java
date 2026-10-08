class Solution {
    int[] dp;

    int fun(int[] nums, int i) {

        if (i == 0) {
            return nums[0];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        return dp[i] = Math.max(nums[i], fun(nums, i - 1) + nums[i]);
    }

    int minFun(int[] nums, int i) {

        if (i == 0) {
            return nums[0];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        return dp[i] = Math.min(nums[i], minFun(nums, i - 1) + nums[i]);
    }

    public int maxSubarraySumCircular(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, fun(nums, i));
        }

        Arrays.fill(dp, -1);

        int sum = 0;

        for (int x : nums) {
            sum += x;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, minFun(nums, i));
        }

        if (sum == min) {
            return max;
        }

        return Math.max(max, sum - min);
    }
}