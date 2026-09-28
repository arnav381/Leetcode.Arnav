class Solution {
    int[][] dp = new int[301][301];
    int fun (int i, int j, char[][] matrix){
        if (i >= matrix.length || j >= matrix[i].length){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int down = fun (i + 1, j, matrix);
        int right = fun (i, j + 1, matrix);
        int diagonal = fun (i + 1, j + 1, matrix);

        int ans = 0;
        if (matrix[i][j] == '1'){
            ans = 1 + Math.min(down, Math.min(right, diagonal));
        }
        return dp[i][j] = ans;
    }
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < 301; i++){
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, fun(i, j, matrix));
            }
        }
        return max * max;        
    }
}