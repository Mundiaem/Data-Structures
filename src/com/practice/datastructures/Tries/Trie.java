package com.practice.datastructures.Tries;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    Node() {

    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

public class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            // moves to the reference trie
            node.get(word.charAt(i));

        }
        node.setEnd();
    }

    /**
     * Returns it the word is in the trie
     * TC -> O(len)
     */

    boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }

    /**
     * Return true is there is any word in the trie that start with the prefix
     * @param prefix
     * @return
     * TC -> O(len)
     */
    boolean startWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) return false;
            node.get(prefix.charAt(i));
        }
        return true;

    }

}
