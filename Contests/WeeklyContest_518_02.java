class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        long first = 0;
        long last = 0;
        
        for (int i = 0; i < half; i++){
            first += nums[i];
        }
        for (int i = half; i < n; i++){
            last += nums[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if (first > last){
                count++;
            }
            int index = i + half;
            if (index >= n){
                index -= n;
            }
            first = first - nums[i] + nums[index];
            last = last - nums[index] + nums[i];
        }
        return count;
    }
}