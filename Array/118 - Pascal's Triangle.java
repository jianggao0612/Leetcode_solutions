/**
 * Pascal's Triangle
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {

    	List<List<Integer>> result = new ArrayList<List<Integer>>();

    	if (numRows == 0){

    		return result; // return an empty list

    	} else if (numRows == 1) { // return the first row containing 1
    	    
    		ArrayList<Integer> rowList = new ArrayList<Integer>();
    		rowList.add(1);
    		result.add(rowList);
    		
    	} else if (numRows >= 2) {
    		ArrayList<Integer> firstRow = new ArrayList<Integer>();
    		ArrayList<Integer> lastRow = new ArrayList<Integer>();
    		
    		// deal with the first two rows
    		firstRow.add(1);
    		lastRow.add(1);
    		lastRow.add(1);
    		result.add(firstRow);
    		result.add(lastRow); 

    		int row = 3;

    		while (row <= numRows) {
    			
    			ArrayList<Integer> currRow = new ArrayList<Integer>();

    			currRow.add(1);

    			for (int i = 1; i < row - 1; i++) {
    				currRow.add(lastRow.get(i - 1) + lastRow.get(i));
    			}
    			currRow.add(1);
    			result.add(currRow);
    			lastRow = currRow;
    			row++;
    		}
    	}  
    	
		return result;
    }
}