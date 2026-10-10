class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++){
            int rem = nums[i] % k;
            long sum = 0;

            for (int j = i; j < nums.length; j++){

                if (nums[j] % k != rem){
                    break;
                }

                sum += nums[j];

                if (sum % k == rem){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}