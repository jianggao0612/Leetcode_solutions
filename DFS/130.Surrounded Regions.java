/**
 *
 * Surrounded Regions
 *
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *******************************************************************************************
 * Union all Os on the four board lines to one union; all Os in other part to one union.
 * Those Os that are ont on the board lines should be flipped.
 * Use a zeroRoot as an index for all Os on the board lines.
 *******************************************************************************************
 */
 public class Solution {
    public void solve(char[][] board) {

        // corner case
        if ((board == null) || (board.length == 0) || (board[0].length == 0)) {
            return;
        }

        int r = board.length;
        int c = board[0].length;
        UnionFind unionFind = new UnionFind(r * c + 1);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }

                int index = i * c + j;
                if ((i == 0) || (i == (r - 1)) || (j == 0) || (j == (c - 1))) {
                    unionFind.union(index, r * c);
                    continue;
                }

                if (board[i - 1][j] == 'O') {
                    unionFind.union(index, index - c);
                }

                if (board[i + 1][j] == 'O') {
                    unionFind.union(index, index + c);
                }

                if (board[i][j - 1] == 'O') {
                    unionFind.union(index, index - 1);
                }

                if (board[i][j + 1] == 'O') {
                    unionFind.union(index, index + 1);
                }

            }
        }

        int rootIndex = unionFind.find(r * c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if ((board[i][j] == 'O') && (unionFind.find(i * c + j) != rootIndex)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private class UnionFind {
        int[] index;
        int count;

        UnionFind(int n) {
            index = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                index[i] = i;
            }
            count = n + 1;
        }

        public int find(int item) {

            while (index[item] != item) {
                index[item] = index[index[item]];
                item = index[item];
            }

            return item;
        }

        public boolean isConnected(int item1, int item2) {
            return find(item1) == find(item2);
        }

        public void union(int item1, int item2) {
            int src = find(item1);
            int dst = find(item2);

            if (src != dst) {
                index[src] = dst;
                count--;
            }
        }

        public int size() {
            return count;
        }
    }
}
