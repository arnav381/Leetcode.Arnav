class Solution {

    int[][] dp = new int[1001][1001];
    int fun (int i, int j, String s){

        if (i == s.length()){
            return 0;
        }

        if (j == s.length()){
            return fun (i + 1, i + 1, s);
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int a = 0;

        if (s.charAt(i) == s.charAt(j)){
            int l = i, r = j;

            while (l < r && s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }

            if (l >= r){
                a += 1;
            }
        }

        return dp[i][j] = a + fun (i, j + 1, s);
    }
    public int countSubstrings(String s) {

        for (int i = 0; i < 1001; i++){
            Arrays.fill(dp[i], -1);
        }

        return fun (0, 0, s);
    }
}