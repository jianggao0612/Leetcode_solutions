/**
 * Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
 public class Solution {
     public int numIslands(char[][] grid) {

         // corner case
         if (grid == null) {
             return 0;
         }

         int r = grid.length;
         if (r == 0) {
             return 0;
         }

         int c = grid[0].length;
         if (c == 0) {
             return 0;
         }

         UnionFind unionFind = new UnionFind(grid, r, c);

         for (int i = 0; i < r; i++) {
             for (int j = 0; j < c; j++) {

                 if (grid[i][j] == '0') {
                     continue;
                 }

                 int index = i * c + j;
                 System.out.println(index);

                 if ((i > 0) && (grid[i - 1][j] == '1')) {
                     unionFind.union(index, index - c);
                 }

                 if ((i < (r - 1)) && (grid[i + 1][j] == '1')) {
                     unionFind.union(index, index + c);
                 }

                 if ((j > 0) && (grid[i][j - 1] == '1')) {
                     unionFind.union(index, index - 1);
                 }

                 if ((j < (c - 1)) && (grid[i][j + 1] == '1')) {
                     unionFind.union(index, index + 1);
                 }
             }
         }

         return unionFind.size();
     }


     private class UnionFind {

         private int[] index;
         private int count;

         UnionFind(char[][] grid, int r, int c) {

             index = new int[r * c];
             count = 0;

             for (int i = 0; i < r * c; i++) {
                 index[i] = i;
             }

             for (int i = 0; i < r; i++) {
                 for (int j = 0; j < c; j++) {
                     if (grid[i][j] == '1') {
                         count++;
                     }
                 }
             }
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
