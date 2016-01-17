/**
 *
 * Find the number Weak Connected Component in the directed graph.
 *
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 *
 * Example
 * Given graph:
 *
 * A----->B  C
 *  \     |  |
 *   \    |  |
 *    \   |  |
 *     \  v  v
 *      ->D  E <- F
 * Return {A,B,D}, {C,E,F}. Since there are two connected component which are {A,B,D} and {C,E,F}
 *
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {

        // corner case
        if ((nodes == null) || (nodes.size() == 0)) {
            return null;
        }

        List<List<Integer> result = new ArrayList<List<Integer>>();
        int length = nodes.size();
        UnionFind unionFind = new UnionFind(length);

        for (int i = 0; i < length; i++) {
            DirectedGraphNode node = nodes.get(i);
            ArrayList<DirectedGraphNode> neighbors = node.neighbors;

            for (int j = 0; j < neighbors.size(); j++) {
                unionFind.union(node, neighbors.get(j));
            }
        }

        ArrayList<Integer> visitedLable = new ArrayList<Integer>();
        for (int key: unionFind.index.keySet()) {
            for
            ArrayList<Integer> union = new ArrayList<Integer>();
            union.add(unionFind.index.get(key));


        }

    }

    private class UnionFind {
        private Map<Integer, Integer> index;
        private int count;

        UnionFind() {

        }

        UnionFind(int n) {
            index = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                index.put(i, i);
            }
            count = n;
        }

        public boolean isConnected(int item1, int item2) {
            return index.get(item1) == index.get(item2);
        }

        public int find(int item) {
            return index.get(item);
        }

        public void union(int item1, int item2) {
            int src = index.get(item1);
            int dst = index.get(item2);

            if (src != dst) {
                for (int key: index.keySet()) {
                    if (index.get(key) == src) {
                        index.put(key, dst);
                    }
                }
            }
            count--;
        }

        public int size() {
            return count;
        }

    }
}
