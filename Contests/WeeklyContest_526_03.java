class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int n = nums.length;
        int swap = 0;
        int unlock = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1 - i; j++){

                if (nums[j] > nums[j + 1]){

                    if (locked[j] == 1){
                        locked[j] = 0;
                        unlock++;
                    }

                    if (locked[j + 1] == 1){
                        locked[j + 1] = 0;
                        unlock++;
                    }

                    if (unlock > k){
                        return -1;
                    }

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swap++;
                }
            }
        }

        return swap + unlock;
    }
}©leetcode