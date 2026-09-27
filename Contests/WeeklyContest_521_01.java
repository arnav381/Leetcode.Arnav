class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; i++){
            freq[nums[i]] = freq[nums[i]] + 1;
        }
        int[] ans = new int[nums.length];
        int k = 0;
        while (k < nums.length){
            for (int i = 1; i <= 100; i++){
                if (freq[i] > 0){
                    ans[k] = i;
                    k++;
                    freq[i]--;   
                }
            }
        }
        return ans;
    }
}