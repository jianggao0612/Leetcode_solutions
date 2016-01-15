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

         Map<Integer, ArrayList<Integer>> edgeMap = new HashMap<Integer, ArrayList<Integer>>();

         // transfer the edges to key-value pairs
         for (int[] edge: edges) {
             if (edgeMap.containsKey(edge[0])){
                 edgeMap.get(edge[0]).add(edge[1]);
             } else {
                 ArrayList<Integer> list = new ArrayList<Integer>();
                 list.add(edge[1]);
                 edgeMap.put(edge[0], list);
             }

             if (edgeMap.containsKey(edge[1])) {
                 edgeMap.get(edge[1]).add(edge[0]);
             } else {
                 ArrayList<Integer> list = new ArrayList<Integer>();
                 list.add(edge[0]);
                 edgeMap.put(edge[1], list);
             }
         }

         Set<Integer> visitedNode = new HashSet<Integer>();
         Set<String> visitedEdge = new HashSet<String>();
         Stack<Integer> stack = new Stack<Integer>();

         stack.add(edges[0][0]);

         while (!stack.isEmpty()) {
             int node = stack.pop();
             visitedNode.add(node);

             if (edgeMap.containsKey(node)) {
                 ArrayList<Integer> list = edgeMap.get(node);
                 for (int i = 0; i < list.size(); i++) {
                     int nextNode = list.get(i);
                     String edge = node + "->" + nextNode;
                     String reverseEdge = nextNode + "->" + node;

                     if (!visitedEdge.contains(edge) && !visitedEdge.contains(reverseEdge)) {
                         if (visitedNode.contains(list.get(i))) {
                             return false;
                         } else {
                             stack.push(list.get(i));
                             visitedNode.add(nextNode);
                             visitedEdge.add(edge);
                             visitedEdge.add(reverseEdge);
                         }
                     } else {
                         continue;
                     }
                 }
             }
         }

         if (visitedNode.size() < n) {
             return false;
         }

         return true;
     }
}
