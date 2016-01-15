/**
 * Graph Valid Tree
 *
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 *
 * For example:
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 */
 public class Solution {
     public boolean validTree(int n, int[][] edges) {

         // corner case
         if ((edges == null) || (edges.length == 0)) {
             if (n <= 1) {
                 return true;
             } else {
                 return false;
             }
         }

         // define a UnionFind object for validation
         UnionFind unionFind = new UnionFind(n);

         // for each pair, carry out union and find operation
         for (int[] edge: edges) {

             // if a newly coming pair is not connected in unionFind, union them
             if (!unionFind.isConnected(edge[0], edge[1])) {
                 unionFind.union(edge[0], edge[1]);
             } else {
                 // if a newly coming pair is already in a same union
                 // which means they have somehow connected before
                 // then there should be a cycle
                 return false;
             }

         }

         // if it is a connected graph, there should be just one union
         if (unionFind.size() == 1) {
             return true;
         } else{
             return false;
         }
     }

     /**
      * Class presentation for the unionFind data structure.
      */
     private class UnionFind {
         /**
          * Index array indicating the union index for each item.
          */
         int[] index;
         /**
          * Total number of unique unions in the unionFind structure.
          */
         int count;

         /**
          * Construct method without argument.
          */
         UnionFind() {

         }

         /**
          * Construct method with given number of items.
          */
         UnionFind(int n) {
             index = new int[n];
             // initially, put each item in a seperate union, use the item itself as the index
             for (int i = 0; i < n; i++) {
                 index[i] = i;
             }

             count = n;
         }

         /**
          * union - Put the two items in a union, use the second item's index as the union index;
          *                  update all the items with index1 to index2
          */
         public void union(int item1, int item2) {
             int src = find(item1);
             int dst = find(item2);

             if (src != dst) {
                 for (int i = 0; i < index.length; i++) {
                     if (index[i] == src) {
                         index[i] = dst;
                     }
                 }
                 count--;
             }
         }

         /**
          * find - Return the index for a given item.
          */
         public int find(int item) {
             return index[item];
         }

         /**
          * isConnected - Determine whether two items are connected.
          *               If they are in the same union, connected.
          *               If not, not connected.
          */
         public boolean isConnected(int item1, int item2) {
             return index[item1] == index[item2];
         }

         /**
          * size - Return the number of unique unions.
          */
         public int size() {
             return count;
         }
     }
}
