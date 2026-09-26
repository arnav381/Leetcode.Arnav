class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sum1 = 0, sum2 = 0;
        for (int x : source){
            sum1 += x;
        }
        for (int y : target){
            sum2 += y;
        }
        if (sum1 != sum2){
            return false;
        }
        for (int i = 0; i < source.length - 1; i++){
            int j = i + 1;
            int delta = source[i] + source[j] - target[i];
            source[i] = source[i] + source[j] - delta;
            source[j] = delta;
        }
        return true;
    }
}