class Solution {

    int[] dp = new int[20005];

    int fun(int i, int[] nums, Map<Integer, Integer> map) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = map.get(nums[i]);

        if (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
            take += fun(i + 2, nums, map);
        } else {
            take += fun(i + 1, nums, map);
        }

        int notTake = fun(i + 1, nums, map);

        dp[i] = Math.max(take, notTake);

        return dp[i];
    }

    public int deleteAndEarn(int[] nums) {

        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        int[] arr = new int[map.size()];

        int k = 0;

        for (int num : map.keySet()) {
            arr[k++] = num;
        }
        Arrays.sort(arr);

        Arrays.fill(dp, -1);

        return fun(0, arr, map);
    }
}