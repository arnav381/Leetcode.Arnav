class Solution {
    int[] dp = new int[1002];
    int fun (int i, int[][] pairs){
        if (i >= pairs.length){
            return 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        int id = pairs.length;
        int left = i + 1;
        int right = pairs.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if (pairs[mid][0] > pairs[i][1]){
                id = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        int a = 1 + fun (id, pairs);
        int b = fun (i + 1, pairs);
        return dp[i] = Math.max(a, b);
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.fill(dp, -1);
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        return fun (0, pairs);
    }
}