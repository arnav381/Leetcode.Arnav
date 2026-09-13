class Solution {
    public long shadowPairs(int[] nums) {
        List<Integer> list = new ArrayList<>();
        long ans = 0;
        for (int k : nums){
            int left = 0;
            int right = list.size();
            while (left < right){
                int mid = left + (right - left)/2;
                if (list.get(mid) < k){
                    left = mid + 1;
                }
                else {
                    right = mid;
                }
            }
            ans += left;

            while (!list.isEmpty() && list.get(list.size() - 1) > k){
                list.remove(list.size() - 1);
            }
            list.add(k);
        }
        return ans;
    }
}