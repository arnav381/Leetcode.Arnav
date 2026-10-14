class Solution {

    int[][]dp = new int[201][201];

    int fun(int i, int j, int[][] dungeon) {

        if (i >= dungeon.length || j >= dungeon[i].length) {
            return Integer.MAX_VALUE;
        }

        if (i == dungeon.length - 1 && j == dungeon[i].length - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if (dp[i][j]!= -1) {
            return dp[i][j];
        }

        int c1 = fun(i + 1, j, dungeon);
        int c2 = fun(i, j + 1, dungeon);

        int need = Math.min(c1, c2) - dungeon[i][j];

        return dp[i][j] = Math.max(1, need);
    }

    public int calculateMinimumHP(int[][] dungeon) {

        for (int i = 0; i < 201; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fun (0, 0, dungeon);
    }
}