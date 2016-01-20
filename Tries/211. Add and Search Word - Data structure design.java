/**
 * Add and Search Word - Data structure design
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 * A . means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */
 public class WordDictionary {

    private class TrieNode {
        boolean isEnd;
        TrieNode[] neighbors;

        TrieNode() {
            isEnd = false;
            neighbors = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode();

    // public WordDictionary() {
    //      root = new TrieNode();
    // }

    // Adds a word into the data structure.
    public void addWord(String word) {

        // corner case
        if ((word == null) || (word.length() == 0)) {
            return;
        }

        TrieNode node = root;
        // keep adding new characters
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (node.neighbors[index] == null) {
                node.neighbors[index] = new TrieNode();
            }
            node = node.neighbors[index];
        }

        // when reaching the last character, set it as the end of a word
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        // corner case
        if ((word == null) || (word.length() == 0)) {
            return false;
        }

        // recursively call the search function to search the word in the trie tree
        return searchHelper(root, word, 0);
    }

    public boolean searchHelper(TrieNode node, String word, int index) {

        // base case
        if (node == null) {
            return false;
        }

        // base case
        if (index == word.length()) {
            return node.isEnd;
        }

        char lable = word.charAt(index);

        if (lable == '.') {
            // if it is '.', search all the possible nodes
            for (int i = 0; i < node.neighbors.length; i++) {
                if (searchHelper(node.neighbors[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int position = lable - 'a';
            if (node.neighbors[position] != null) {
                return searchHelper(node.neighbors[position], word, index + 1);
            } else {
                return false;
            }
        }
    }
 }


// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
