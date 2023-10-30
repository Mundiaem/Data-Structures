package com.practice.datastructures.Tries;

import java.util.List;

class NodeXOR {
    NodeXOR[] links = new NodeXOR[2];

    public void put(int index, NodeXOR node) {
        links[index] = node;
    }

    public boolean containsKey(int index) {
        return links[index] != null;
    }

    public NodeXOR get(int index) {
        return links[index];
    }

}

class TrieXOR {
    static NodeXOR root;

    TrieXOR() {
        root = new NodeXOR();
    }

    void insert(int num) {
        NodeXOR node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new NodeXOR());
            }
            node = node.get(bit);
        }

    }

    int getMax(int num) {
        NodeXOR node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = ((num >> i) & 1);
            //contains opposite of it
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);

            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }

}

public class MaximumXOR {
    public static void main(String[] args) {

    }

    private static int getMax(int n, int m, List<Integer> lst1, List<Integer> lst2) {
        TrieXOR trie = new TrieXOR();
        int max = 0;

        for (int num : lst1) {
            trie.insert(num);
        }
        for (int num : lst2) {
            max = Math.max(max, trie.getMax(num));
        }
        return max;
    }
}
