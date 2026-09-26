class Solution {
    int[][] dp;
    boolean check(String a, String b) {
        if (b.length() != a.length() + 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                j++;
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }

    int fun(int i, int prev, String[] words) {
        if (i >= words.length) {
            return 0;
        }
        if (dp[i][prev + 1] != -1) {
            return dp[i][prev + 1];
        }

        int a = 0;
        if (prev == -1 || check(words[prev], words[i])) {
            a = 1 + fun(i + 1, i, words);
        }
        int b = fun(i + 1, prev, words);

        return dp[i][prev + 1] = Math.max(a, b);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp = new int[words.length][words.length + 1];
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(0, -1, words);
    }
}