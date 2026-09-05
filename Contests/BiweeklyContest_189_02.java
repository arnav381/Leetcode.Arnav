class Solution {
    private int fun(String s){
        int count = 0;
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            if(s.charAt(i)!=s.charAt(j)){
                int a1 = s.charAt(i)-'a';
                int a2 = s.charAt(j)-'a';
                int c1 = Math.abs(a1-a2);
                int c2 = 26 - Math.abs(a1-a2);    
                count += Math.min(c1,c2);
            }    
            i++;
            j--;
        }
        return count;
    }
    public int minOperations(String s) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            String rotate = s.substring(i)+s.substring(0,i);
            int cost = fun(rotate)+i;
            min = Math.min(min,cost);
        }
        return min;
    }
}
