public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Integer index1 = null;
        Integer index2 = null;
        int shortest = 0;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
                if(index2 != null) {
                    shortest = compute(shortest, index1, index2);
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
