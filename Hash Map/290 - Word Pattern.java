/**
 *
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {

    	Map<Character, String> patternMap = new HashMap<Character, String>();   // a map to associate character and string 
		String[] words = str.split(" ");    // get all the words
        
		if (words.length != pattern.length()) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {
			Character c = pattern.charAt(i);
			
			if(patternMap.containsKey(c)) {
			    if (patternMap.get(c).equals(words[i])) {
			        continue;
			    } else {
			        return false;
			    }
			} else {
			    if (patternMap.containsValue(words[i])) {
			        return false;
			    }
				patternMap.put(c, words[i]);

			}

		}

		return true;
    }
}