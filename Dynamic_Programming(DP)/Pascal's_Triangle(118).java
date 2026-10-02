class Solution {
    int[][] dp = new int[31][31];
    int fun (int row, int col){
        if (col == 0 || col == row){
            return 1;
        }
        if (dp[row][col] != 0){
            return dp[row][col];
        }
        return dp[row][col] = fun (row - 1, col - 1) + fun (row - 1, col);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                rows.add(fun(i, j));
            }
            ans.add(rows);
        }

        return ans; 
    }
}