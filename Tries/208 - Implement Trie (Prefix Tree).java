/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
 class TrieNode {
     boolean isEnd;
     char lable;
     HashMap<Character, TrieNode> neighbors;


     public TrieNode() {
         lable = '#';
         isEnd = false;
         neighbors = new HashMap<Character, TrieNode>();
     }

     public TrieNode(char c) {
         lable = c;
         isEnd = false;
         neighbors = new HashMap<Character, TrieNode>();
     }
 }

 public class Trie {
     private TrieNode root;

     public Trie() {
         root = new TrieNode();
     }

     // Inserts a word into the trie.
     public void insert(String word) {
         // corner case
         if ((word == null) || (word.length() == 0)) {
             return;
         }

         TrieNode node = root;
         for (int i = 0; i < word.length(); i++) {

             char lable = word.charAt(i);

             if (node.neighbors.containsKey(lable)) {
                 node = node.neighbors.get(lable);
                 if (i == word.length() - 1) {
                     node.isEnd = true;
                 }
             } else {
                 TrieNode newNode = new TrieNode(lable);
                 if (i == word.length() - 1) {
                     newNode.isEnd = true;
                 }
                 node.neighbors.put(lable, newNode);
                 node = newNode;
             }
         }

     }

     // Returns if the word is in the trie.
     public boolean search(String word) {

         // corner case
         if ((word == null) || (word.length() == 0)) {
             return false;
         }

         TrieNode node = root;

         for (int i = 0; i < word.length(); i++) {
             char lable = word.charAt(i);
             if (node.neighbors.containsKey(lable)) {
                 node = node.neighbors.get(lable);
                 continue;
             } else {
                 return false;
             }
         }

         if (node.isEnd) {
             return true;
         } else {
             return false;
         }

     }

     // Returns if there is any word in the trie
     // that starts with the given prefix.
     public boolean startsWith(String prefix) {

         // corner case
         if ((prefix == null) || (prefix.length() == 0)) {
             return false;
         }

         TrieNode node = root;

         for (int i = 0; i < prefix.length(); i++) {
             char lable = prefix.charAt(i);

             if (node.neighbors.containsKey(lable)) {
                 node = node.neighbors.get(lable);
                 continue;
             } else {
                 return false;
             }
         }

         return true;
     }
 }

 // Your Trie object will be instantiated and called as such:
 // Trie trie = new Trie();
 // trie.insert("somestring");
 // trie.search("key");
