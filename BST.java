/**
 * 08-722 Data Structures for Application Programmers.
 * Lecture 15 Binary Trees, mainly Binary Search Trees
 *
 * A very simple Binary Search Tree implementation
 * No duplicate keys allowed
 *
 * Note: This is only to help your understanding of the concept
 *
 * @author Terry Lee
 */
public class BST implements BSTInterface {

    /**
     * reference to root node.
     */
    private Node root;

    /**
     * Constructs an empty BST.
     */
    public BST() {
        root = null;
    }

    /**
     * Searches for the specified key in the tree.
     * @param key key of the element to search
     * @return boolean value indication of success or failure
     */
    @Override
    public boolean find(int key) {
        // tree is empty
        if (root == null) {
            return false;
        }

        Node curr = root;
        // while not found
        while (curr.key != key) {
            if (curr.key < key) {
                // go right
                curr = curr.right;
            } else {
                // go left
                curr = curr.left;
            }

            // not found
            if (curr == null) {
                return false;
            }
        }
        return true; // found
    }

    /**
     * Inserts a new element into the tree.
     * @param key key of the element
     * @param value value of the element
     */
    @Override
    public void insert(int key, double value) {
        Node newNode = new Node(key, value);
        // empty tree
        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = root; // keep track of parent
        Node curr = root;
        while (true) {
            // no duplicate keys allowed
            // simply keep the existing one here
            if (curr.key == key) {
                return;
            }

            parent = curr; // update parent
            if (curr.key < key) {
                // go right
                curr = curr.right;
                if (curr == null) {
                    // found a spot
                    parent.right = newNode;
                    return;
                }
            } else {
                // go left
                curr = curr.left;
                if (curr == null) {
                    // found a spot
                    parent.left = newNode;
                    return;
                }
            } // end of if-else to go right or left
        } // end of while
    } // end of insert method

    /**
     * Deletes an element from the tree using the specified key.
     * @param key key of the element to delete
     */
    @Override
    public void delete(int key) {
        // empty tree
        if (root == null) {
            return;
        }

        Node parent = root;
        Node curr = root;
        /*
         * flag to check left child
         *
         * need this flag because actual deletion process happens after the
         * while loop that is to find the key to delete
         */
        boolean isLeftChild = true;

        while (curr.key != key) {
            parent = curr; // update parent first
            if (curr.key < key) { // go right
                isLeftChild = false;
                curr = curr.right;
            } else { // go left
                isLeftChild = true;
                curr = curr.left;
            }

            // case 1: not found
            if (curr == null) {
                return;
            }
        }

        if (curr.left == null && curr.right == null) {
            // case 2: leaf
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (curr.right == null) {
            // case 3: no right child
            if (curr == root) {
                root = curr.left;
            } else if (isLeftChild) {
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        } else if (curr.left == null) {
            // case 3: no left child
            if (curr == root) {
                root = curr.right;
            } else if (isLeftChild) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        } else {
            // case 4: with two children
            // here we use successor but using predecessor is also an option
            Node successor = getSuccessor(curr);

            if(curr == root) {
                root = successor;
            } else if(isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = curr.left;
        }
    }

    /**
     * Helper method to find the successor of the toDelete node.
     * This tries to find the smallest value of the right subtree
     * of the delNode by going down to the far left node in the subtree
     * @param toDelete node to delete
     * @return the successor of the toDelete node
     */
    private Node getSuccessor(Node toDelete) {
        Node successorParent = toDelete;
        Node successor = toDelete;
        Node curr = toDelete.right;

        // move down to left as far as possible in the right subtree
        while (curr != null) {
            successorParent = successor;
            successor = curr;
            curr = curr.left;
        }

        /*
         * If successor is NOT the right child of the node to delete, then
         * need to take care of two connections in the right subtree
         */
        if (successor != toDelete.right) {
            successorParent.left = successor.right;
            successor.right = toDelete.right;
        }

        return successor;
    }
    
    /**
     * Traverses and prints values of the tree in ascending order based on key.
     */
    @Override
    public void traverse() {
        inOrderHelper(root);
        System.out.println();
    }

    /**
     * Helper method for in-order traversal.
     * @param toVisit node to visit
     */
    private void inOrderHelper(Node toVisit) {
        if (toVisit != null) {
            inOrderHelper(toVisit.left);
            System.out.print("[" + toVisit.key + ", " + toVisit.value + "]");
            inOrderHelper(toVisit.right);
        }
    }

    /**
     * static nested Node class for Node.
     */
    private static class Node {
        /**
         * Key integer.
         */
        private int key;
        /**
         * double value mapped to the key.
         */
        private double value;
        /**
         * references to left and right children nodes.
         */
        private Node left, right;

        /**
         * Constructs a new node with key and value.
         * @param key integer key
         * @param value double value
         */
        Node(int key, double value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * A few simple test cases.
     * @param args arguments
     */
    public static void main(String[] args) {
        BST theBST = new BST();

        theBST.traverse();
        System.out.println("Searching for 45: " + theBST.find(45));
        theBST.delete(45);

        theBST.insert(50, 0.5);
        theBST.insert(69, 0.4);
        theBST.insert(45, 1.4);
        theBST.insert(72, 3.4);
        theBST.insert(46, 3.3);
        theBST.insert(46, 3.4);

        theBST.traverse();
        System.out.println("Searching for 45: " + theBST.find(45));
        System.out.println("Deleting element of the key 45");
        theBST.delete(45);
        System.out.println("Searching for 45: " + theBST.find(45));
        System.out.println("Deleting element of the key 40");
        theBST.delete(40);
        theBST.traverse();
    }

}
