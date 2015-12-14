/**
 * Count the appearance of each character in the string. If all characters appear even times( or except one ), return true. Otherwise, return false. 
 */

public class Solution {
    
    HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
    
    public boolean canPermutePalindrome(String s) {
        char[] array = s.toCharArray();
        for(char curChar:array) {
            Integer count = charCount.get(curChar);
            if(count == null) {
                charCount.put(curChar, 1);
            } else {
                charCount.put(curChar, count+1);
            }
        } // count the appearance of each character in the string
        
        
        Set<Character> keySet = charCount.keySet();
        
        int oddCount = 0;
        for(char curChar:keySet) {
            if(charCount.get(curChar) % 2 == 1) {
                oddCount++;
                if(oddCount > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}