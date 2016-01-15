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
 *
 * Idea :
 * dead -> dead: 0
 * live -> live: 1
 * live -> dead: 2
 * dead -> live: 3
 * In the board after first scan, cells which mod 2 equal 0 are final dead cell
 * In the middle status, cells with 1 and 2 means the cell is original live
 * Central idea, use one number to represent both the original status and the changed status
 *
 */
 public class Solution {
     public void gameOfLife(int[][] board) {

         // corner case
         if (board == null) {
             return;
         }
         // get the total number of rows in the board
         int r = board.length;
         // corner case
         if (r == 0) {
             return;
         }
         // get the total number of columns in the board
         int c = board[0].length;
         // corner case
         if (c == 0) {
             return;
         }

         // go over the whole board once to set all the status transformation
         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {
                 // get the number of alive neighbors
                 int liveCount = countOfLive(board, i, j, r, c);
                 // do transformation according to the rules
                 if (board[i][j] == 1) {
                     if ((liveCount < 2) || (liveCount > 3)) {
                         board[i][j] = 2;
                     }
                 } else {
                     if (liveCount == 3) {
                         board[i][j] = 3;
                     }
                 }
             }
         }

         // go over the status board again to get the final status at once
         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {
                 // cells with 0 or 2 mean dead
                 board[i][j] %= 2;
             }
         }


     }

     /**
      * Helper function to count the total number of alive neighbors for a give cell board[i][j].
      */
     public int countOfLive(int[][] board, int i, int j, int r, int c) {

         int count = 0;

         // Take care of the first row and column and the last row and column
         for (int m = Math.max(0, i - 1); m <= Math.min(r - 1, i + 1); m++) {
             for (int n = Math.max(0, j - 1); n <= Math.min(c - 1, j + 1); n++) {
                 if ((m == i) && (n == j)) {
                     continue;
                 } else {
                     if ((board[m][n] == 1) || (board[m][n] == 2)) {
                         count++;
                     }
                 }
             }
         }

         return count;
     }
}
