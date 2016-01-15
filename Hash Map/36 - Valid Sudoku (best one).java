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

        Set<String> set = new HashSet<String>();

        // use different strings to code different parts
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (board[i][j] != '.') {
                    String row = i + "r" + board[i][j];
                    String column = j + "c" + board[i][j];
                    String block = i / 3 + "r" + j / 3 + "c" + board[i][j];

                    if (set.contains(row) || set.contains(column) || set.contains(block)) {
                        return false;
                    } else {
                        set.add(row);
                        set.add(column);
                        set.add(block);
                    }
                }

            }
        }

        return true;

    }
}
