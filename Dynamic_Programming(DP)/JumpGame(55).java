class Solution {
    Boolean[] dp;

    boolean fun (int i, int[] nums){

        if (i >= nums.length - 1){
            return true;
        }

        if (dp[i] != null){
            return dp[i];
        }

        for (int j = 1; j <= nums[i]; j++){
            
            if (fun (i + j, nums)){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }

    public boolean canJump(int[] nums) {

        dp = new Boolean[nums.length];

        return fun (0, nums);    
    }
}