class Solution {

    int ans = Integer.MAX_VALUE;
    boolean [][][] dp;

    void fun (int i, int j, int[][] grid, int xor){
        int m = grid.length;
        int n = grid[0].length;

        if (i == m - 1 && j == n - 1){
            ans = Math.min(ans, xor);
            return;
        }

        if (dp[i][j][xor] == true){
            return;
        }
        dp[i][j][xor] = true;

        if (i + 1 < m){
            fun (i + 1, j, grid, xor ^ grid[i + 1][j]);
        }

        if (j + 1 < n){
            fun (i, j + 1, grid, xor ^ grid[i][j + 1]);
        }
    }
    
    public int minCost(int[][] grid) {
        dp = new boolean[grid.length][grid[0].length][1024];

        fun (0, 0, grid, grid[0][0]);
        return ans;
        
    }
}