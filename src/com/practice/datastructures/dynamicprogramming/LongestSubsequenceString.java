package com.practice.datastructures.dynamicprogramming;

/**
 * created with love by mundiaem
 * created on 15/12/2022
 * Time: 16:35
 * ⚡  - Data-Structures
 */

public class LongestSubsequenceString {
    /*
    *
    * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
            A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

            For example, "ace" is a subsequence of "abcde".
            A common subsequence of two strings is a subsequence that is common to both strings.

            Example 1:

            Input: text1 = "abcde", text2 = "ace"
            Output: 3
            Explanation: The longest common subsequence is "ace" and its length is 3.
            Example 2:

            Input: text1 = "abc", text2 = "abc"
            Output: 3
            Explanation: The longest common subsequence is "abc" and its length is 3.
            Example 3:

            Input: text1 = "abc", text2 = "def"
            Output: 0
            Explanation: There is no such common subsequence, so the result is 0.
            * */


    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "abc";
        System.out.println(longestSubsequenceString(text1, text2));
    }

    private static int longestSubsequenceString(String s1, String s2) {
        int ans = 0;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                ans++;
            }else i++;

        }


        return ans;

    }


}
