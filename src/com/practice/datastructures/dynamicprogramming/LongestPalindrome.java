package com.practice.datastructures.dynamicprogramming;

public class LongestPalindrome {
    private static int lo, maxLen;
    private static int resultLength, resultStart;

    public static void main(String[] args) {
        System.out.println(longestPalindrome1("babad"));
        ;
    }

    private static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private static void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    public static String longestPalindrome1(String s) {
        int strLength = s.length();
        if (strLength < 2) {
            return s;
        }
        //input > s= babad
        //output : bab
        /*
        Explanation aba is also a valid parindrome
        Example 2

        input s = cbbd
        output : bb

        Solution

        approach 1
        - have a pointer left and right positions
        - move the pointers toward the center of the string (middle)
        - keep track of the substrings
        - return the longest palindrome

        Approach 2
        - have the pointers start at the middle then right and left positions
        - move the left pointer toward posion zero of the string
        - move the right pointer toward position n-1 of the string
        - keep track of the palindrome
        - return the longest palindrome

        */


        for (int start = 0; start < strLength - 1; start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);

        }


        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int begin, int end) {

        // check that each character from pointers positions are equal provided that begin >=0 and end<strLength
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;

        }
        //After the while loop exit check if the current length of the parindrome is the longer than previous length;
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }

    }
}

