/**
 * Unique Paths II
 *
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 */
 public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // corner case
        if (obstacleGrid == null) {
            return 0;
        }

        // get the number of rows and columns of the array
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;

        // corner case
        if ((r == 0) || (c == 0)) {
            return 0;
        }

        // corner case
        if ((r == 1) && (c == 1)) {
            if (obstacleGrid[0][0] != 1) {
                return 1;
            } else {
                return 0;
            }
        }

        // dp table
        int[][] path = new int[r][c];

        // the first column
        for (int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] != 1) {
                path[i][0] = 1;
            } else {
                break;
            }
        }

        // the first row
        for (int i = 0; i < c; i++) {
            if (obstacleGrid[0][i] != 1) {
                path[0][i] = 1;
            } else {
                break;
            }
        }

        // for each shell, if it's 1 in the obstacle grid, the path to the shell should be 0
        // if not, reaccurance function path[i][j] = path[i - 1][j] + path[i][j - 1]
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] != 1) {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                } else {
                    path[i][j] = 0;
                }
            }
        }

        return path[r - 1][c - 1];
    }
}
