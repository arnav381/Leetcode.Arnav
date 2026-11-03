class Solution {

    int[][] dp;
    int mod = 1000000007;

    int fun(int i, int j, int[][] grid) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long ans = 1;

        if (i > 0 && grid[i - 1][j] > grid[i][j]) {
            ans += fun(i - 1, j, grid);
        }

        if (i + 1 < grid.length && grid[i + 1][j] > grid[i][j]) {
            ans += fun(i + 1, j, grid);
        }

        if (j > 0 && grid[i][j - 1] > grid[i][j]) {
            ans += fun(i, j - 1, grid);
        }

        if (j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]) {
            ans += fun(i, j + 1, grid);
        }

        return dp[i][j] = (int)(ans % mod);
    }

    public int countPaths(int[][] grid) {

        dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        long ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = (ans + fun(i, j, grid)) % mod;
            }
        }

        return (int) ans;
    }
}