class Solution {
    int[][] dp;
    int fun(int i, int j, int[][] matrix) {
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == matrix.length - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int down = fun(i + 1, j, matrix);
        int left = fun(i + 1, j - 1, matrix);
        int right = fun(i + 1, j + 1, matrix);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            ans = Math.min(ans, fun(0, j, matrix));
        }
        return ans;
    }
}