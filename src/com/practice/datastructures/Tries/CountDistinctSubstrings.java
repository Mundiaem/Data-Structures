package com.practice.datastructures.Tries;

class NodeD {
    NodeD[] links = new NodeD[26];

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, NodeD node) {
        links[ch - 'a'] = node;
    }

    NodeD get(char ch) {
        return links[ch - 'a'];

    }
}

public class CountDistinctSubstrings {
    public static void main(String[] args) {
        TrieD trie = new TrieD();
        String s = "abab";
        System.out.printf("This is the distinct substring for %s = %s", s, trie.countDistinctSubstring(s));
    }
}

class TrieD {
    int cnt = 0;
    NodeD root;

    TrieD() {
        root = new NodeD();
    }

    int countDistinctSubstring(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            NodeD node = root;
            for (int j = i; j < n; j++) {
                if (!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new NodeD());
                    cnt++;
                }
                node = node.get(s.charAt(j));
            }

        }
        return cnt + 1;
    }
}
