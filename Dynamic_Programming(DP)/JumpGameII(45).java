class Solution {
    int[] dp;

    int fun (int i, int[] nums){

        if (i >= nums.length - 1){
            return 0;
        }

        if (dp[i] != -1){
            return dp[i];
        }

        int min = Integer.MAX_VALUE;

        for (int j = 1; j <= nums[i]; j++){
            int jumps = fun (i + j, nums);

            if (jumps != Integer.MAX_VALUE){
                
                min = Math.min(min, 1 + jumps);
            }
        }

        return dp[i] = min;
    }

    public int jump(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return fun (0, nums);
    }
}