class Solution {
    int[][] dp = new int[101][2];
    int fun (int i, int[] nums, int f){
        if (i >= nums.length){
            return 0;
        }
        if (dp[i][f] != -1){
            return dp[i][f];
        }
        int c1 = fun (i+1, nums,f);
        int c2 = 0;
        if (i == 0){
            c2 = nums[i] + fun (i+2, nums, 1);
        }
        if (i == nums.length - 1){
            if (f == 0){
                c2 = nums[i];
            } else {
                c2 = 0;
            }
        }
        else if (i != 0){
            c2 = nums[i] + fun (i+2, nums, f);
        }
        int ans = Math.max(c1,c2);
        dp[i][f] = ans;
        return ans;
    }
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return fun (0, nums,0);
    }
}