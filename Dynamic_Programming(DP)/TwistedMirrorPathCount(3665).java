class Solution {

    int mod = 1000000007;
    int[][][] dp;

    int fun (int i, int j, int direction, int[][] grid){

        if (i >= grid.length || j >= grid[0].length){
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1){
            return 1;
        }

        if (dp[i][j][direction] != -1){
            return dp[i][j][direction];
        }

        int ans = 0;

        if (grid[i][j] == 1){
            // direction == 0 --> moving right and direction == 1 --> moving down

            if (direction == 0){
                ans = fun (i + 1, j, 1, grid);
            }

            else {
                ans = fun (i, j + 1, 0, grid);
            }

            return dp[i][j][direction] = ans;
        }
        
        int right = fun (i, j + 1, 0, grid);
        int down = fun (i + 1, j, 1, grid);

        return dp[i][j][direction] = (right + down) % mod;
    }

    public int uniquePaths(int[][] grid) {
        dp = new int[grid.length][grid[0].length][2];

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return fun (0, 0, 0, grid);
    }
}