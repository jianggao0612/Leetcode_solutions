/**
 * Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 ********************************************** DFS ************************************************
 */
 public class Solution {
     public boolean exist(char[][] board, String word) {

         // corner case
         if (board == null) {
             return false;
         }
         if (word == null) {
             return false;
         }

         // get the length of the word
         int length = word.length();
         // get the number of rows and columns of the grid
         int r = board.length;
         int c = board[0].length;

         // corner case
         if (length == 0) {
             return false;
         }

         // dfs for every starting point in the grid
         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {
                 if (dfs(board, word, 0, i, j)) {
                     return true;
                 }
             }
         }

         return false;

     }

     /**
      * Helper function to do dfs of the graph.
      *
      * @params board the searching grid
      * @params word the searching word
      * @params index the index of the character in the word to be searched
      * @params i the row index of the point
      * @params j the column index of the point
      */
     public boolean dfs(char[][] board, String word, int index, int i, int j) {

         // base case
         if (index == word.length()) {
             return true;
         }

         // base case
         if ((i < 0) || (j < 0) || (i >= board.length) || (j >= board[0].length)) {
             return false;
         }

         // base case
         if (board[i][j] != word.charAt(index)) {
             return false;
         }

         // temporarily disable the current point for this round of search to avoid repeat use
         char tmp = board[i][j];
         board[i][j] = '*';

         // recursively call dfs to search for the whole word
         if (dfs(board, word, index + 1, i - 1, j) ||
             dfs(board, word, index + 1, i + 1, j) ||
             dfs(board, word, index + 1, i, j - 1) ||
             dfs(board, word, index + 1, i, j + 1)) {
             return true;
         }

         // reset the point after this round
         board[i][j] = tmp;
         // if not found, return false
         return false;

     }
}
