class Solution {
    int rows,cols;
    int ans = 0;
    int fun (int i, int j, int grid[][], int left){
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == -1){
            return 0;
        }
        if (grid[i][j] == 2){
            if (left == -1){
                ans++;
            }
            return 0;
        }
        int temp1 = grid[i][j];
        grid[i][j] = -1;
        int c1 = fun (i + 1, j, grid, left - 1);
        grid[i][j] = temp1;

        int temp2 = grid[i][j];
        grid[i][j] = -1;
        int c2 = fun (i, j + 1, grid, left - 1);
        grid[i][j] = temp2;

        int temp3 = grid[i][j];
        grid[i][j] = -1;
        int c3 = fun (i - 1, j, grid, left - 1);
        grid[i][j] = temp3;

        int temp4 = grid[i][j];
        grid[i][j] = -1;
        int c4 = fun (i, j - 1, grid, left - 1);
        grid[i][j] = temp4;
        return c1 + c2 + c3 + c4;
    }
    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        ans = 0;

        int total = 0;
        int si = 0;
        int sj = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 0){
                    total++;
                }
                if (grid[i][j] == 1){
                    si = i;
                    sj = j;
                }
            }
        }
        fun (si, sj, grid, total);
        return ans;        
    }
}