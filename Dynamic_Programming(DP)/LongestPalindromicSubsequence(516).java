class Solution {
    int [][] dp = new int[1002][1002];
    int fun (String s, int i, int j){
        if (i > j){
            return 0;
        }
        if (i == j){
            return 1;
        }
        if (dp [i][j] != -1){
            return dp[i][j];
        }
        int max = 0;
        if (s.charAt(i) == s.charAt(j)){
            int a = 2 + fun (s, i+1, j-1);
            max = Math.max(max, a);
        }
        else {
            int a = fun (s, i+1, j);
            int b = fun (s, i, j-1);
            max = Math.max(max, a);
            max = Math.max(max, b);
        }
        return dp[i][j] = max;
    }
    public int longestPalindromeSubseq(String s) {
        for (int i = 0; i < 1002; i++){
            Arrays.fill(dp[i], -1);
        }
        return fun (s, 0, s.length() - 1);
    }
}