/**
 * Specially check the condition of same word // Could be more generic though
 */

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Integer index1 = null;
        Integer index2 = null;
        int shortest = 0;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                if(word1.equals(word2)) {
                    // Special case for same word. use one pointer to record last position of the word
                    if(index1 == null) {
                        index1 = i;
                    } else {
                        index2 = i;
                        shortest = compute(shortest, index1, index2);
                        index1 = i;
                        index2 = null;
                    }
                } else {
                    index1 = i;
                    if(index2 != null) {
                        shortest = compute(shortest, index1, index2);
                    }
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if(index1 != null) {
                    shortest = compute(shortest, index1, index2);
                }
            }
        }
        return shortest;
    }
    
    public int compute(int current, int idx1, int idx2) {
        if(current == 0) {
            return Math.abs( idx1 - idx2);
        }
        
        int path = Math.abs(idx1 - idx2);
        return path < current? path:current;
    }
}
