/**
 * First sort the array. For each element, try to use two pointers from front and tail(since it is sorted) to iteratively search for possible combination.
 * Attention: need to get rid of the duplicates
 */

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < nums.length -2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int sum = -1;
            
            while( j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                } else if(sum < 0){
                    j++;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    // System.out.println("i:"+i+", j:"+j +",k:"+k);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    
                    while(i <= nums.length -2 && nums[i] == nums[i+1]) {
                        i++;
                    }
                    
                    while(j < nums.length - 1 && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while(k >= 1 && nums[k] == nums[k-1] ) {
                        k--;
                    }
                    if(j >= k) {
                        break;
                    }
                    
                    j++; // could also be k--;
                }
            }
            
        }
        return result;
        
    }
}
