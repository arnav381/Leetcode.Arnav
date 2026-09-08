class Solution {
    long[] dp = new long[100003];
    long fun (int i, int[] power, Map<Integer,Long> map){
        if (i >= power.length){
            return 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        int current = power[i];
        int ni = power.length;

        int left = i + 1;
        int right = power.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (power[mid] > current + 2) {
                ni = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        long take = map.get(current) + fun(ni, power, map);
        long notTake = fun (i+1, power, map);
        dp[i] = Math.max(take, notTake);
        return dp[i];
    }
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        HashMap<Integer, Long> map = new HashMap<>();

        for (int nums : power) {
            map.put(nums, map.getOrDefault(nums, 0L) + nums);
        }
        Arrays.fill(dp, -1);
        return fun (0, power, map);    
    }
}