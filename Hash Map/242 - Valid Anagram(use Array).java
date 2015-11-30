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

    /**
     * Number of all lower-case characters (avoid magic number)
     */
    public static final int LENGTH_OF_CHARACTER = 26;

    public boolean isAnagram(String s, String t) {

        int sLength = s.length();
        int tLength = t.length();
        
        if ((sLength == 0) && (tLength == 0)) {
            return true;
        }
        
        if (sLength != tLength) {
            return false;
        }

        int[] charArray = new int[LENGTH_OF_CHARACTER]; // array to store the occurance of all the characters

        for (int i = 0; i < sLength; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            charArray[sChar - 'a']++;
            charArray[tChar - 'a']--;
        }
        
        for (int i = 0; i < LENGTH_OF_CHARACTER; i++) {

            if (charArray[i] == 0) {
                continue;
            } else {
                return false;
            }

        }

        return true;
        
    }
}