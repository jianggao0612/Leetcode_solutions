public class Solution {
    public void nextPermutation(int[] nums) {
        int lastBigger = -1;
        int length = nums.length;
        int temp = 0;
        int nextBigger = -1;

        for (int i = 0; i < length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                lastBigger = i;
            }
        }

        if (lastBigger == -1) {
            // such arrangement is not possible
            for (int i = 0; i < length / 2; i++) {
                temp = nums[i];
                nums[i] = nums[length - 1 - i];
                nums[length - 1 - i] = temp;
            }
            return;
        }

        // invert all elements after lastBigger
        for (int i = lastBigger + 1; i <= (length - 1 - lastBigger) / 2 + lastBigger; i++) {
            temp = nums[i];
            nums[i] = nums[length - 1 - (i - (lastBigger + 1))];
            nums[length - 1 - (i - (lastBigger + 1))] = temp;
        }

        // Find the next bigger number than nums[lastBigger]
        nextBigger = lastBigger;
        for (int i = lastBigger + 1; i < length; i++) {
            if (nums[i] > nums[lastBigger]) {
                if (nextBigger == lastBigger || nums[i] < nums[nextBigger])
                nextBigger = i;
            }
        }

        // swap nums[lastBigger] and nums[nextBigger]
        temp = nums[nextBigger];
        nums[nextBigger] = nums[lastBigger];
        nums[lastBigger] = temp;
    }
}
