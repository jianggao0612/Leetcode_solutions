/**
 * Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
 public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        // corner case
        if (triangle == null) {
            return 0;
        }

        // get the total number of rows
        int r = triangle.size();
        // corner case
        if (r == 0) {
            return 0;
        }

        // DP trace
        int[] sum = new int[r];
        // base case
        sum[0] = triangle.get(0).get(0);

        // for each row, sum[i][j] = Min(sum[i - 1][j - 1] + sum[i][j], sum[i - 1][j] + sum[i][j])
        for (int i = 1; i < r; i++) {
            int c = triangle.get(i).size();
            // TRICK: Reversely get all the optimal sum for each row, since there is only one array.
            // Otherwise, new sum will overwrite old sum which may be in use for calculation
            // Deal with the first and last element seperately, since they both only have one possible path
            sum[c - 1] = sum[c - 2] + triangle.get(i).get(c - 1);
            for (int j = c - 2; j > 0; j--) {
                int element = triangle.get(i).get(j);
                sum[j] = Math.min(sum[j - 1] + element, sum[j] + element);
            }
            sum[0] =  sum[0] + triangle.get(i).get(0);
        }

        // go over the array to get the optimal
        int min = sum[0];
        for (int num: sum) {
            min = min < num ? min : num;
        }

        return min;
    }
}
