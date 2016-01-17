/**
 * Word Ladder
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
 public class Solution {
     public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

         // corner case
         if ((wordList == null) || wordList.isEmpty()) {
             return 0;
         }

         ArrayList<String> queue = new ArrayList<String>();
         int length = 0;
         queue.add(beginWord);

         while (!queue.isEmpty()) {
             int level = queue.size();

             for (int i = 0; i < level; i++) {
                 String compareWord = queue.remove(0);
                 length++;

                 // compare the current word with the end word
                 int diff = 0;
                 for (int c = 0; c < compareWord.length(); c++) {
                     if (compareWord.charAt(c) != endWord.charAt(c)) {
                         diff++;
                     }
                     if (diff > 1) {
                         break;
                     }
                 }

                 if (diff == 1) {
                     return ++length;
                 }

                 findTrans(compareWord, wordList, queue);
                 length--;
             }
         }

         return 0;
     }

     public void findTrans(String word, Set<String> wordList, ArrayList<String> queue) {

         // get the length of the word for looping
         int length = word.length();

         for (int i = 0; i < length; i++) {

             StringBuilder builder = new StringBuilder();

             if (i != 0) {
                 // append the first (i - 1) characters
                 builder.append(word.substring(0, i));
             }

             // do transformation among a-z for the ith character
             for (char c = 'a'; c <= 'z'; c++) {
                 builder.append(c);
                 builder.append(word.substring(i + 1, length));

                 String transString = builder.toString();
                 if ((!transString.equals(word)) && (wordList.contains(transString))) {
                     queue.add(transString);
                 }
             }
         }

         return;
     }
}
