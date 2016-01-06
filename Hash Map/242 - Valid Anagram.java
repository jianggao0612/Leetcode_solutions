/**
 * Valid Anagram
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 *
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        
        if ((s.length() == 0) && (t.length() == 0)) {
            return true;
        }
        
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        sMap = generateMap(s);
        tMap = generateMap(t);
        
        for (Character key: sMap.keySet()) {
            if (tMap.containsKey(key) && (tMap.get(key).equals(sMap.get(key)))) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public HashMap<Character, Integer> generateMap(String s) {
        
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }
        
        return result;
    }
}