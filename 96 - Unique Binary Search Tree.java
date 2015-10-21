/**
 * Unique Binary Search Trees
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * Idea: When choosing i as the root, the number of different unique BST is num(left_trees) * num(right_trees)
 * How many number of different trees in left tree or right tree is determined by the number of nodes in that sub tree
 * n = 0, num(0) = 1;
 * n = 1, num(1) = 1;
 * n = 2, num(2) = num(1) * num(0) + num(0) * num (1)
 * n = 3, num(3) = num(2) * num(0) + num(1) * num (1) + num(0) * num(2)
 * n = n, num(n) = num(n-1) * num(0) + num(n-2) * num(1) + ... + num(0) * num(n-1)
 */
public class Solution {
    public int numTrees(int n) {

    	int[] count = new int[n + 1]; // notice that the array stores 0 - n, total num is n + 1 (easy to make mistake in arrayOutOfBound)
    	count[0] = 1;
    	count[1] = 1;

    	for (int i = 2; i <= n ; i++) {
    		for (int j = 0; j < i; j++){
    			count[i] = count[i] + count[j] * count[i - j - 1];
    		}
    	}

    	return count[n];
        
    }
}