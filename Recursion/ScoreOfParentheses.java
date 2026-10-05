class Solution {
    int i = 0;
    int fun (String s){
        int ans = 0;

        while (i < s.length() && s.charAt(i) == '('){
            i++;
            
            if (s.charAt(i) == ')'){
                ans += 1;
                i++;
            }

            else {
                ans += 2 * fun (s);
                i++;
            }
        }
        return ans;
    }
    public int scoreOfParentheses(String s) {
        return fun (s);
    }
}