/**
 * Verify Preorder Sequence in Binary Search Tree
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 *
 * Recursive implementation
 *
 ***********************************************************************************************************************************
 * Idea: Recall the characteristics of the preorder of a BST. 
 * For the first node(root) in the array, go over the array, find the first node k in the array which is larger than the first node. 
 * Then elements ahead of this node k should be in the left sub-tree of root, the other half shoud in the right sub-tree of root.
 * Since the first half must be all less than root, so determine whether all the element in the second half are larger than root.
 * If not, it's not a BST.
 * Iteratively determine whether the left sub-tree and the right sub-tree are BST.
 ***********************************************************************************************************************************
 *
 */
public class Solution {
    public boolean verifyPreorder(int[] preorder) {

    	// Corner case (0 or 1 are both true)
    	if (preorder.length <= 1)
    	    return true;

    	return verifyPreorderBST(preorder, 0, preorder.length - 1); // recursive call
        
    }

    public boolean verifyPreorderBST(int[] preorder, int start, int end) {

    	if (start > end)
    		return true;

    	// Get the root element for this iteration
    	int root = preorder[start];

    	/*
    	 * find the first element that is larger than root
    	 */
    	int i = start + 1;
    	while (i < end && preorder[i] < root)
    		i++;

    	/*
    	 * there could be no element that is larger than root (only have left sub-tree)
    	 */
    	if (i < end) {
    		
    		/*
    		 * determine whether all the elements in the right sub-tree are larger than root
    		 */
    		int j = i;
    		while (j <= end && preorder[j] > root) 
    			j++;

    		if (j <= end)
    			return false;

    		return verifyPreorderBST(preorder, start + 1, j - 1) && verifyPreorderBST(preorder, j , end); // recursively determine the left and right sub-tree

    	} else {

    		return verifyPreorderBST(preorder, start + 1, end); // if no element larger than root, only need to test the left sub-tree

    	}

    }
}