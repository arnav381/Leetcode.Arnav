class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = len - 1;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] < nums[i]){
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            }
            arr[left] = nums[i];
            if (left == len){
                len++;
            }
        }
        return len;
    }
}