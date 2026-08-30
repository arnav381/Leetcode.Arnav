class Solution {
    public String[] largestString(int[] nums) {
        String[] ans = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            String str = "";
            int n = nums[i];
            
            for (int j = 25; j >=0; j--){
            int power = (int) Math.pow(2,j);
            while(n >= power){
            str += (char)('a'+j);
            n = n - power;
            }
            }
            ans[i] = str;
        }
        return ans;
    }
}