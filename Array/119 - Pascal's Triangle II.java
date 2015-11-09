/**
 * Pascal's Triangle
 *
 * Given an index k, return the kth row of the Pascal's triangle. 
 * Use O(k) extra space.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {

    	List<Integer> result = new ArrayList<Integer>();

        if (rowIndex == 0) { // NOTE: index starting from 0

            result.add(1);

        } else if (rowIndex == 1) {

        	result.add(1);
        	result.add(1);

        } else {

        	List<Integer> lastRow = new ArrayList<Integer>();
        	lastRow.add(1);
        	lastRow.add(1);

        	int row = 2;

        	while (row <= rowIndex) {

        		List<Integer> currRow = new ArrayList<Integer>();
        		currRow.add(1);

        		for (int i = 1; i < row; i++) { // note the bound change comparing to the other question

    				currRow.add(lastRow.get(i - 1) + lastRow.get(i));

    			}
    			
    			currRow.add(1);
    			lastRow = currRow;
    			row++;
        	}

        	result = lastRow;

        }
        
        return result;
    }
}