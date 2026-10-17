class Solution {

    int[][] dp = new int[1001][1001];
    int fun (int i, int j, String s, String t){

        if (j == t.length()){
            return 1;
        }

        if (i == s.length()){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)){

            int a = fun (i + 1, j + 1, s, t);
            int b = fun (i + 1, j, s, t);
            
            return dp[i][j] = a + b;
        }

        return dp[i][j] = fun (i + 1, j, s, t);
    }
    public int numDistinct(String s, String t) {

        for (int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }

        return fun (0, 0, s, t);
    }
}