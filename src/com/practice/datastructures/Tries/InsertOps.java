package com.practice.datastructures.Tries;

class NodeI {
    NodeI[] links = new NodeI[26];
    int cntEndWith = 0;
    int cntPrefix = 0;

    NodeI() {

    }

    NodeI get(char ch) {
        return links[ch - 'a'];
    }

    boolean containsKey(char ch) {
        return (links[ch - 'a']) != null;
    }

    void put(char ch, NodeI node) {
        links[ch - 'a'] = node;
    }

    void increaseEnd() {
        cntEndWith++;
    }

    void increasePrefix() {
        cntPrefix++;
    }

    void deleteEnd() {
        cntEndWith--;
    }

    void reducePrefix() {
        cntPrefix--;
    }

    int getCntEndWith() {
        return cntEndWith;
    }

    int getCntPrefix() {
        return cntPrefix;

    }


}

public class InsertOps {
    NodeI root;

    InsertOps() {
        root = new NodeI();
    }

    void insert(String word) {
        NodeI node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new NodeI());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    int countWordsEqualTo(String word) {
        NodeI node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getCntEndWith();
    }

    int countWordsStartWith(String word) {
        NodeI node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node.get(word.charAt(i));
            } else return 0;
        }
        return node.getCntPrefix();
    }

    void erase(String word){
        NodeI node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else {
                return;
            }
        }
        node.deleteEnd();
    }
}
