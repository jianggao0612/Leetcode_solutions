/**
 * Number of Islands II
 *
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
 public class Solution {
     public List<Integer> numIslands2(int m, int n, int[][] positions) {

         List<Integer> result = new ArrayList<Integer>();
         // corner case
         if ((m == 0) || (n == 0) || (positions == null) || (positions.length == 0) || (positions[0].length == 0)) {
             return result;
         }

         // initialize the grid with all water
         int[][] grid = new int[m][n];
         // initialize a unionFind object
         UnionFind unionFind = new UnionFind(m * n);

         // go over the positions to add islands
         for (int[] position: positions) {
             // get the position of the island
             int r = position[0];
             int c = position[1];
             // transfer the 2D position to 1D position in the unionFind index array
             int index = r * n + c;
             // fill the grid with one
             grid[r][c] = 1;
             // suppose no connected island, increase the number of island at first
             unionFind.count++;

             // search the four neighbors of the newly added island to see whether they are connected
             // if so, union them and deduct the number of island
             // notice if the grid exists only one island after any union operation, stop since all are connected to 1
             if ((unionFind.count > 1) && (r > 0) && (grid[r - 1][c] == 1)) {
                 unionFind.union(index, index - n);
             }
             if ((unionFind.count > 1) && (r < (m - 1)) && (grid[r + 1][c] == 1)) {
                 unionFind.union(index, index + n);
             }
             if ((unionFind.count > 1) && (c > 0) && (grid[r][c - 1] == 1)) {
                 unionFind.union(index, index - 1);
             }
             if ((unionFind.count > 1) && (c < (n - 1)) && (grid[r][c + 1] == 1)) {
                 unionFind.union(index, index + 1);
             }

             // number of unique unions in unionFind should be the number of island after this round of add operation
             result.add(unionFind.count);
         }

         return result;
     }

     private class UnionFind {

         int[] index;
         int count;

         UnionFind(int n) {
             index = new int[n];
             for (int i = 0; i < n; i++) {
                 index[i] = i;
             }
             count = 0;
         }

         public int find(int item) {
             while (item != index[item]) {
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
     }
 }
