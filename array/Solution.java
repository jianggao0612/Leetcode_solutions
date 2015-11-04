/**
 *	Use last level result to compute current level result. The idea is pretty straight forward
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> curRow = new ArrayList<Integer>();

		// Corner case        
        if(numRows == 0) {
            return result;
        }
        
        curRow.add(1);
        result.add(curRow);
            
		// Corner case
        if(numRows == 1) {
            return result;
        }
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i-1);
            curRow = new ArrayList<Integer>();
            curRow.add(1); // First add left side 1
            for(int j = 0; j < prevRow.size()-1; j++) {
                curRow.add(prevRow.get(j) + prevRow.get(j+1)); // compute all elements for this level based on last level
            }
            curRow.add(1); // Finally, add right side 1 
            result.add(curRow);
        }
        
        return result;
    }
}
