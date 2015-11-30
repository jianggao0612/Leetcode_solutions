/**
 * Palindrome Permutation
 * 
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 *
 ************************************Idea*******************************************
 * Should not have more than one characters with odd numbers of appearance
 *
 */
 public class Solution {
    public boolean canPermutePalindrome(String s) {
        
        // corner cases
        if (s == null) {
            return false;
        }

        int length = s.length();
        if (length <= 1) {
            return true;
        }
        
        // a map to store the character and corresponding counts of appearance
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int count = 0; // count for odd numbers of appearance
        
        for (int i = 0; i < length; i++) {
            char key = s.charAt(i);
            
            if (charMap.containsKey(key)) {
                charMap.put(key, charMap.get(key) + 1);
            } else {
                charMap.put(key, 1);
            }
        }
        
        for (Character key: charMap.keySet()) {
            
            if (charMap.get(key) % 2 == 0) {
                continue;
            } else {
                count++;
            }

            if (count > 1) {
            	// if there are more than one characters apprear in odd time, not a parlidrome permutation
                return false;
            }
            
        }
        
        return true;
        
    }
}