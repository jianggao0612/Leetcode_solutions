/**
 * Again... DP... Difference: once it is 1, set current slot to 0; as for top and left boundary, need to get the value based on "previous" one(in case of unreachable)
 */

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int col = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        
        int[][] grid = new int[row][col];
        
        if(obstacleGrid[0][0] == 1) {
            return 0;
        } 
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(obstacleGrid[i][j] == 1) {
                        grid[i][j] = 0;
                } else if(i == 0) {
                    if(j == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = grid[i][j-1];
                    }
                } else if (j == 0) {
                    grid[i][j] = grid[i-1][j];
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[row-1][col-1];
    }
}
