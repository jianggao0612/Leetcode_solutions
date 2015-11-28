// Use binary string to represent different combinations

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        int length = nums.length;
        if(length < 1) {
            return result;
        }
        
        int size = (int)Math.pow(2, nums.length) - 1;
        for(int i = 0; i <= size; i++) {
            ArrayList<Integer> subList = new ArrayList<Integer>();
            String binaryStr = Integer.toBinaryString(i);
            for(int j = 0; j < binaryStr.length(); j++) {
                char flag = binaryStr.charAt(binaryStr.length() - j - 1);
                if(flag == '1') {
                   subList.add(nums[j]);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
