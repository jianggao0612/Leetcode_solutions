/**
 * Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 */
 public class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        // corner cases
        if ((s.length() == 0) && (t.length() == 0)) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        // hashMap to store the character-substitute matches
        Map<Character, Character> matchMap = new HashMap<Character, Character>();
        // hashSet to store exisited pairs of matches (use hashSet but hashMap.containsValue to reduce runtime)
        Set<Character> usedSet = new HashSet<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            
            if (matchMap.containsKey(key)) {
            	// if the char in s appeared again, check its match
                if (value == matchMap.get(key)) {
                    continue;
                } else {
                    return false;
                }
            } else {
            	// if the char in s hasn't appeared before, check whether its substitute has been used or put it in the map
                if (usedSet.contains(value)) {
                    return false;
                } else {
                    matchMap.put(key, value);
                    usedSet.add(value); // update the set
                }
            }
        }
        
        return true;
        
    }
}