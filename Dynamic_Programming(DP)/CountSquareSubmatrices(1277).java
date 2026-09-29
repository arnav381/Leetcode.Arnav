class Solution {
    int[][] dp = new int[301][301];
    int fun (int i, int j, int[][] matrix){
        if (i >= matrix.length || j >= matrix[i].length){
            return 0;
        }
        if (matrix[i][j] == 0){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int right = fun (i, j + 1, matrix);
        int down = fun (i + 1, j, matrix);
        int diagonal = fun (i + 1, j + 1, matrix);

        return dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
    }
    public int countSquares(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < 301; i++){
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                ans += fun (i, j, matrix);
            }
        }
        return ans;
    }
}