package com.practice.datastructures.Tries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PrefixNode {
    Map<Character, PrefixNode> childNodeMap = new HashMap<>();
    Character value;

    public PrefixNode(Character c) {
        this.value = c;
    }

    public boolean hasNoChildren() {
        return this.childNodeMap.isEmpty();
    }

    public boolean hasChild(Character c) {
        return this.childNodeMap.containsKey(c);
    }

    public PrefixNode addChild(Character c) {
        if (!childNodeMap.containsKey(c)) {
            this.childNodeMap.put(c, new PrefixNode(c));
        }
        return this.childNodeMap.get(c);
    }
}

class Result {



    public static void noPrefix(List<String> words) {

        PrefixNode headNode = new PrefixNode('z');
        for (String word : words) {
            char[] charArray = word.toCharArray();
            PrefixNode currentNode = headNode;
            if (headNode.hasNoChildren()) {
                for (Character currentChar : charArray) {
                    currentNode = currentNode.addChild(currentChar);
                }
            } else {
                boolean isMatched = true;
                for (Character currentChar : charArray) {
                    if (currentNode.hasNoChildren() && isMatched) {
                        System.out.println("BAD SET");
                        System.out.println(word);
                        return;
                    }
                    if (!currentNode.hasChild(currentChar)) {
                        isMatched = false;
                    }
                    currentNode = currentNode.addChild(currentChar);
                }
                if (isMatched) {
                    System.out.println("BAD SET");
                    System.out.println(word);
                    return;
                }
            }
        }
        System.out.println("GOOD SET");


    }
}

public class NoPrefix {
    public static void main(String[] args) {
        List<String> words = List.of("aab",
                "defgab",
                "abcde",
                "cedaaa",
                "bbbbbbbbbb",
                "jabjjjad");
        List<String> words1 = List.of("aab",
                "defgab",
                "abcde",
                "aabcde",
                "cedaaa",
                "bbbbbbbbbb",
                "jabjjjad");



        Result.noPrefix(words1);
    }
}
