/**
 * Start from bigger value, fill up tails first. if the smaller array finished, all elements are in correct order
 */

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int size = m + n - 1;
        
        while(i >= 0 && j >=0) {
            if(nums1[i] > nums2[j]) {
                nums1[size] = nums1[i];
                i--;
            } else {
                nums1[size] = nums2[j];
                j--;
            }
            size--;
        }
        
        while(j >= 0) {
            nums1[size] = nums2[j];
            size--;
            j--;
        }
           
    }
}
