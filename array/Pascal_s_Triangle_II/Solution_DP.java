// Using dp to iteratively get each level values based on previous level

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int [] array = new int[rowIndex+1];
        
        rowIndex = rowIndex + 1;
        if(rowIndex == 0) {
            return new ArrayList<Integer>();
        }
        
        // First row
        array[0] = 1;
        
        for(int i = 1; i < rowIndex; i++) {
            for(int j = i-1; j >=1 ; j--) {
                array[j] = array[j] + array[j-1];
            }
            array[i] = 1;
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for( int num : array) {
            result.add(num);
        }
        return result;
    }
}
