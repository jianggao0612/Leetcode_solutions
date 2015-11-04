/**
 * Shortest Word Distance
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * 
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

    	// Corner case
    	if (words.length <= 1)
            return 0;
            
        int currWord1 = -1; // pointer to word 1
        int currWord2 = -1; // pointer to word 2
        int currDistance = words.length - 1;
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {

            if (word1.equals(words[i])) // update position for word 1
                currWord1 = i;
            if (word2.equals(words[i])) // update position for word 2
                currWord2 = i;
            
            if ((currWord1 != -1) && (currWord2 != -1))
                currDistance = Math.abs(currWord1 - currWord2);
            
            if (currDistance < minDistance) // update shortest distance
                minDistance = currDistance;
        }
        
        return minDistance;
        
    }
}