class Solution {
    int[] fun (int i, int j, char[][] grid){

        if (grid[i][j] == '*'){
            return new int[]{i, j};
        }

        char ch = grid[i][j];
        grid[i][j] = '*';

        if (ch == 'L'){
            
            if (j == 0 || grid[i][j - 1] == '*') {
                return new int[]{i, j};
            }
            
            return fun (i, j - 1, grid);
        }

        if (ch == 'R'){
            
            if (j == grid[0].length - 1 || grid[i][j + 1] == '*'){
                return new int[]{i, j};
            }
            
            return fun (i, j + 1, grid);
        }

        if (ch == 'U'){
            
            if (i == 0 || grid[i - 1][j] == '*'){
                return new int[]{i, j};
            }
            
            return fun (i - 1, j, grid);
        }
        
        if (i == grid.length - 1 || grid[i + 1][j] == '*'){
            return new int[]{i, j};
        }
        
        return fun (i + 1, j, grid);
    }
    public int[] lastVisitedCell(char[][] grid) {
        return fun (0, 0, grid);        
    }
}