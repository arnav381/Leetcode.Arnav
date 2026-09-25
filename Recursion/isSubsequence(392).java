class Solution {
    boolean fun (int i, int j, String s, String t){
        if (i >= s.length()){
            return true;
        }
        if (j >= t.length()){
            return false;
        }
        if (s.charAt(i) == t.charAt(j)){
            return fun (i + 1, j + 1, s, t);
        } else {
            return fun (i, j + 1, s, t);
        }
    }
    public boolean isSubsequence(String s, String t) {
        return fun (0, 0, s, t);        
    }
}