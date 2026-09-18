class Solution {
    int [][] dp = new int [201][201];
    int fun (int i, int j, int [][] grid){
        if (i >= grid.length || j >= grid[i].length){
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[i].length - 1){
            return grid[i][j];
        }
        if (dp [i][j] != -1){
            return dp [i][j];
        }
        if (i == grid.length - 1){
            return grid [i][j] + fun (i, j+1, grid);
        }
        if (j == grid[i].length - 1){
            return grid [i][j] + fun (i+1, j, grid);
        }
        int c1 = grid[i][j] + fun (i+1, j, grid);
        int c2 = grid[i][j] + fun (i, j+1, grid);
        return dp [i][j] = Math.min(c1, c2);
    }
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return fun (0, 0, grid);        
    }
}