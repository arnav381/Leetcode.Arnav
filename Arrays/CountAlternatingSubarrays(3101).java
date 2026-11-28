class Solution {
    public long countAlternatingSubarrays(int[] nums) {

        int count = 1;
        long ans = 1;

        for (int i = 1; i < nums.length; i++){

            if (nums[i] != nums[i - 1]){
                count++;
            }

            else {
                count = 1;
            }

            ans += count;
        }

        return ans;
    }
}