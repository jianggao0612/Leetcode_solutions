/**
 * Valid Sudoku
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
 public class Solution {
    public boolean isValidSudoku(char[][] board) {

        // corner case
        if ((board == null) || (board.length == 0)) {
            return false;
        }

        int r = board.length;
        int c = board[0].length;
        Set<Character> set = new HashSet<Character>();

        // check for each row
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }


        // check for each column
        for (int j = 0; j < c; j++) {
            for (int i = 0; i < r; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        // check for each block
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int m = i * 3; m < 3 + i * 3; m++) {
                    for (int n = j * 3; n < 3 + j * 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }
                        if (set.contains(board[m][n])){
                            return false;
                        } else {
                            set.add(board[m][n]);
                        }
                    }
                }
                set.clear();
            }
        }

        return true;

    }
}
