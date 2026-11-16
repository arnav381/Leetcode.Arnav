class Solution {
    Boolean[] dp;

    boolean fun (int i, int[] arr){

        if (i < 0 || i >= arr.length){
            return false;
        }

        if (arr[i] == 0){
            return true;
        }

        if (dp[i] != null){
            return dp[i];
        }

        dp[i] = false;

        boolean c1 = fun(i + arr[i], arr);
        boolean c2 = fun(i - arr[i], arr);

        return dp[i] = c1 || c2;
    }

    public boolean canReach(int[] arr, int start) {

        dp = new Boolean[arr.length];

        return fun(start, arr);
    }
}