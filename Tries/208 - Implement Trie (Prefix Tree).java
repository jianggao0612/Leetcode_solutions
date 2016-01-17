/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
    public TrieNode() {
        boolean isEnd;
        char lable;
        HashMap<Character, TriesNode> neighbors;

        public TriesNode() {
            lable = '#';
            isEnd = false;
            neighbors = new HashMap<Character, TriesNode>();
        }

        public TriesNode(char c) {
            lable = c;
            this.isEnd = false;
            neighbors = new HashMap<Charcter, TriesNode>();
        }
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
        if ((word == null) || (word.length == 0)) {
            return;
        }

        TriesNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char lable = word.charAt(i);
            TriesNode newNode = new TriesNode(lable);
            if (i == word.length() - 1) {
                newNode.isEnd = true;
            }
            if (node.neighbors.containsKey(lable)) {
                node = neighbors.get(lable);
                continue;
            } else {
                node.neighbors.put(lable, newNode);
                node = newNode;
            }
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
