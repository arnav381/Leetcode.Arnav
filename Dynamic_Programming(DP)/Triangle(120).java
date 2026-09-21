class Solution {
    int[][] dp = new int[201][201];
    int fun (List<List<Integer>> triangle, int i, int j){
        if (i == triangle.size() - 1){
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }         
        int c1 = fun (triangle, i + 1, j);
        int c2 = fun (triangle, i + 1, j + 1);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(c1, c2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < 201; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return fun (triangle, 0, 0);
    }
}