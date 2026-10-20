class Solution {

    int start = 0, max = 0;

    void fun(int l, int r, String s) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {

            if (r - l + 1 > max) {
                max = r - l + 1;
                start = l;
            }

            l--;
            r++;
        }
    }

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            fun(i, i, s);       
            fun(i, i + 1, s);
        }

        return s.substring(start, start + max);
    }
}