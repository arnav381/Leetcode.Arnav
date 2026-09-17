class Solution {
    int [][] dp = new int[101][101];
    int fun(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 1) {
            return 0;
        }
        if (dp [i][j] != -1){
            return dp[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        int down = fun(i + 1, j, grid);
        int right = fun(i, j + 1, grid);
        return dp[i][j] = down + right;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < 101; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun(0, 0, obstacleGrid);
    }
}