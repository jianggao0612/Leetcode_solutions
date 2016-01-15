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
        Set<Character> rowSet = new HashSet<Character>();
        Set<Character> columnSet = new HashSet<Character>();

        // check for each row and column at the same time
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j])) {
                        return false;
                    } else {
                        rowSet.add(board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    if (columnSet.contains(board[j][i])) {
                        return false;
                    } else {
                        columnSet.add(board[j][i]);
                    }
                }

            }
            rowSet.clear();
            columnSet.clear();
        }

        rowSet.clear();

        // check for each block
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int m = i * 3; m < 3 + i * 3; m++) {
                    for (int n = j * 3; n < 3 + j * 3; n++) {
                        if (board[m][n] == '.') {
                            continue;
                        }
                        if (rowSet.contains(board[m][n])){
                            return false;
                        } else {
                            rowSet.add(board[m][n]);
                        }
                    }
                }
                rowSet.clear();
            }
        }

        return true;

    }
}
