class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int current = 0;
        int high = nums.length - 1;

        while (current <= high){

            if (nums[current] == 0){

                int temp = nums[low];
                nums[low] = nums[current];
                nums[current] = temp;

                low++;
                current++;
            }

            else if (nums[current] == 1){
                current++;
            }

            else {

                int temp = nums[current];
                nums[current] = nums[high];
                nums[high] = temp;

                high--; 
            }
        }
    }
}