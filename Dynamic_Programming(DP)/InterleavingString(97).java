class Solution {
    int[][][] dp = new int[101][101][201];
    int fun(int i, int j, int k, String s1, String s2, String s3) {
        if (i >= s1.length()) {
            while (j < s2.length() && k < s3.length()) {
                if (s2.charAt(j) == s3.charAt(k)) {
                    j++;
                    k++;
                } else {
                    return 0;
                }
            }
            return 1;
        }
        if (j >= s2.length()) {
            while (i < s1.length() && k < s3.length()) {
                if (s1.charAt(i) == s3.charAt(k)) {
                    i++;
                    k++;
                } else {
                    return 0;
                }
            }
            return 1;
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        int m = 0;
        if (s1.charAt(i) == s3.charAt(k)) {
            int a = fun(i + 1, j, k + 1, s1, s2, s3);
            m = m | a;
        }
        if (s2.charAt(j) == s3.charAt(k)) {
            int b = fun(i, j + 1, k + 1, s1, s2, s3);
            m = m | b;
        }
        if (s1.charAt(i) != s3.charAt(k) && 
            s2.charAt(j) != s3.charAt(k)) {
            return 0;
        }
        return dp[i][j][k] = m;
    }
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 201; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return fun(0, 0, 0, s1, s2, s3) == 1;
    }
}