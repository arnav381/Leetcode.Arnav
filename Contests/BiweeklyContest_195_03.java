class Solution {
    public long countValidSubstrings(String s) {

        long count = 0;
        int left = 0;

        int a = -1;
        int ab = -1;

        for (int right = 0; right < s.length(); right++){

            if (s.charAt(right) == 'a'){
                a = right;
            }

            if (s.charAt(right) == 'b' && a != -1){
                ab = a;
            }

            if (s.charAt(right) == 'c' && ab != -1){
                left = Math.max(left, ab + 1);
            }
            
            count += right - left + 1;
        }
        return count;
    }
}