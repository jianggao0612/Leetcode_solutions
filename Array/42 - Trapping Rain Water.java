/**
 *
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
 public class Solution {
    public int trap(int[] height) {

        // corner case
        if ((height == null) || (height.length <= 2)) {
            return 0;
        }

        int leftBoard = 0, rightBoard = height.length - 1;
        int leftPointer = 0, rightPointer = height.length - 1;
        int water = 0;

        while (leftPointer < rightPointer) {
          if (height[leftBoard] < height[rightBoard]) {
                while (((++leftPointer) < rightPointer) && (height[leftPointer] < height[leftBoard])) {
                    water += (height[leftBoard] - height[leftPointer]);
                }
                leftBoard = leftPointer;
            } else {
                while ((leftPointer < (--rightPointer)) && (height[rightPointer] < height[rightBoard])) {
                    water += (height[rightBoard] - height[rightPointer]);
                }
                rightBoard = rightPointer;
            }
        }

        return water;

    }
}
