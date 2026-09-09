class Solution {
    int[] dp = new int[366];
    int fun (int i, int[] days, int[] costs){
        if (i >= days.length){
            return 0;
        }
        if (dp[i] != -1){
            return dp[i];
        }
        int oneDay = costs[0] + fun (i+1, days, costs);
        int j = i;
        while (j < days.length && days[j] < days[i] + 7){
            j++;
        }
        int sevenDay = costs[1] + fun(j, days, costs);
        int k = i;
        while (k < days.length && days[k] < days[i] + 30){
            k++;
        }
        int thirtyDay = costs[2] + fun(k, days, costs);
        dp[i] = Math.min(oneDay,Math.min(sevenDay, thirtyDay));
        return dp[i];
    }
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp,-1);
        return fun(0, days, costs);        
    }
}