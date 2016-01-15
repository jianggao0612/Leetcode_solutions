/**
 * Game of Life
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal)
 * using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 *
 * Follow up:
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
 public class Solution {
     public void gameOfLife(int[][] board) {

         // corner cause
         if (board == null) {
             return;
         }

         int r = board.length;
         if (r == 0) {
             return;
         }

         int c = board[0].length;
         if (c == 0) {
             return;
         }

         ArrayList<int[]> status = new ArrayList<int[]>();
         boolean flag = false;

         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {
                 int live = countOfLive(board, i, j, r, c);
                 if (board[i][j] == 1) {
                     if (live < 2) {
                         flag = true;
                     } else if (live > 3) {
                         flag = true;
                     } else {
                         flag = false;
                     }
                 }

                 if (board[i][j] == 0) {
                     if (live == 3) {
                         flag = true;
                     } else {
                         flag = false;
                     }
                 }

                 if (flag) {
                     int[] change = new int[2];
                     change[0] = i;
                     change[1] = j;
                     status.add(change);
                 }
             }
         }

         for (int i = 0; i < status.size(); i++) {
             int row = status.get(i)[0];
             int column = status.get(i)[1];

             board[row][column] = (board[row][column] == 1) ? 0 : 1;
         }

     }

     public int countOfLive(int[][] board, int i, int j, int r, int c) {

         int count = 0;

         for (int m = Math.max(0, i - 1); m <= Math.min(r - 1, i + 1); m++) {
             for (int n = Math.max(0, j - 1); n <= Math.min(c - 1, j + 1); n++) {
                 if ((m == i) && (n == j)) {
                     continue;
                 } else {
                     count += board[m][n];
                 }
             }
         }

         return count;
     }
}
