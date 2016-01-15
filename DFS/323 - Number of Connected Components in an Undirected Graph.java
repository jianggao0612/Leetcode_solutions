/**
 * Number of Connected Components in an Undirected Graph
 *
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 *
 * Example 1:
 *     0          3
 *     |          |
 *     1 --- 2    4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 * Example 2:
 *     0           4
 *     |           |
 *     1 --- 2 --- 3
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 *
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
 public class Solution {
    public int countComponents(int n, int[][] edges) {

        // corner case
        if ((edges == null) || (edges.length == 0)) {
            return n;
        }

        UnionFind unionFind = new UnionFind(n);

        for (int[] edge: edges) {
            if (!unionFind.isConnected(edge[0], edge[1])) {
                unionFind.union(edge[0], edge[1]);
            }
        }

        return unionFind.size();
    }

    private class UnionFind {
        private int[] index;
        private int count;

        UnionFind(int n) {
            index = new int[n];

            for (int i = 0; i < n; i++) {
                index[i] = i;
            }

            count = n;
        }

        public int find(int item) {
            return index[item];
        }

        public boolean isConnected(int item1, int item2) {
            return index[item1] == index[item2];
        }

        public void union(int item1, int item2) {
            int src = index[item1];
            int dst = index[item2];

            if (src != dst) {
                for (int i = 0; i < index.length; i++) {
                    if (index[i] == src) {
                        index[i] = dst;
                    }
                }
                count--;
            }
        }

        public int size() {
            return count;
        }
    }
}
