package com.practice.datastructures.Tries;

import java.util.List;

class LNode {
    LNode[] links = new LNode[26];
    boolean flag = false;

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    LNode get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, LNode node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

public class LTrie {

    private static LNode root;

    LTrie() {
        root = new LNode();
    }

    void insert(String word) {
        LNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new LNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    static boolean checkIfAllPrefixExist(String word) {
        boolean fl = true;
        LNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if (node.isEnd()) return false;

            }
            return false;
        }
        return true;
    }

    static String longestCommonPrefix(int n, List<String> stringList) {
        LTrie trie = new LTrie();
        for (String s : stringList) {
            trie.insert(s);
        }
        String longest = "";
        for (String word : stringList) {
            if (checkIfAllPrefixExist(word)) {
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length() && word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}
