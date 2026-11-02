class Solution {
    int[][] dp;

    int fun (int i, int j, int[][] grid){

        if (i < 0 || i >= grid.length || j >= grid[0].length){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int c1 = 0, c2 = 0, c3 = 0;

        if (i > 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > grid[i][j]){
            c1 = 1 + fun (i - 1 , j + 1, grid);
        }

        if (j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]){
            c2 = 1 + fun (i, j + 1, grid);
        }

        if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] > grid[i][j]){
            c3 = 1 + fun (i + 1, j + 1, grid);
        }

        return dp[i][j] = Math.max(c1, Math.max(c2, c3));
    }

    public int maxMoves(int[][] grid) {

        dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < grid.length; i++){

            ans = Math.max(ans, fun (i, 0, grid));
        }

        return ans;
    }    
}