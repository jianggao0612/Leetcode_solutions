/**
 * Two steps: 1. using binary search to get row that target exist
 *            2. using binary search to search in the row if previous step succeeded
 */

class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
                    if(matrix.length < 0 ) {
                                    return false;
                                            } // check corner case
                            
                            if(matrix[0].length < 0) {
                                            return false;
                                                    } // check corner case
                                    
                                    int row = getRow(matrix, 0, matrix.length-1, target);
                                            
                                            if(row == -1) {
                                                            return false;
                                                                    }
                                                    
                                                    return binarySearch(matrix[row], 0, matrix[0].length-1, target);
                                                        }
            
            /**
             *      * Binary Search in a row 
             *           */
            public boolean binarySearch(int[] row, int left, int right, int target) {
                        if(left > right) {
                                        return false;
                                                }
                                
                                int mid = ( left + right ) / 2;
                                        if(row[mid] == target) {
                                                        return true;
                                                                }
                                                
                                                if(row[mid] < target) {
                                                                return binarySearch(row, mid+1, right, target);
                                                                        } else {
                                                                                        return binarySearch(row, left, mid-1, target);
                                                                                                }
                                                    }
                
                /**
                 *      *  Find the row that target exist
                 *           */
                public int getRow(int[][] matrix, int left, int right, int target) {
                            int mid = (left + right) / 2;
                                    int columnSize = matrix[0].length;
                                            
                                            if(left > right) {
                                                            return -1; // not found
                                                                    }
                                                    
                                                    if(matrix[mid][0] <= target && matrix[mid][columnSize-1] >= target) {
                                                                    return mid;
                                                                            } else if(matrix[mid][0] > target) {
                                                                                            return getRow(matrix, left, mid-1, target);
                                                                                                    } else {
                                                                                                                    return getRow(matrix, mid+1, right, target);
                                                                                                                            }
                                                        }
}
