package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AlphabetBoard {
    //TODO
    // https://leetcode.com/problems/alphabet-board-path/
    public static void main(String[] args) {
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        int sum = numbers.stream()
                .flatMap(List::stream)
                .filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}
