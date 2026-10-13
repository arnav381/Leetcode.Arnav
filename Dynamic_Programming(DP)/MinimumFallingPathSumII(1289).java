class Solution {
    int[][] dp = new int[201][201];

    int fun (int i, int j, int[][] grid){

        if (i == grid.length - 1){
            return grid[i][j];
        }

        if (dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < grid[0].length; k++){

            if (k != j){

                int next = fun (i + 1, k, grid);
                ans = Math.min(ans, next);
            }
        }

        return dp[i][j] = grid[i][j] + ans;
    }

    public int minFallingPathSum(int[][] grid) {

        for (int i = 0; i < 201; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < grid[0].length; j++){

            ans = Math.min(ans, fun (0, j, grid));
        }
        return ans;        
    }
}