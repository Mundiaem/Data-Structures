package com.practice.datastructures.string;

/**
 * Longest Palindromic Substring
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, return the longest
 * palindromic
 * <p>
 * substring
 * in s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String[] strings = {"babad", "cbbd"};
        for (String s : strings) {
            System.out.println("This is the palindrome =  " + s + "   " + longestPalindrome(s));
            ;
        }
    }

    static int max , low ;

    private static String longestPalindrome(String s) {
        max=0;
        low=0;
        int n = s.length();
        if(n<2) return s;
        for (int i = 0; i < n; i++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
        return s.substring(low, low +max);
    }

    private static void palindrome(String s, int start, int end) {
        while (start>=0 &&  s.length()>end && s.charAt(start)==s.charAt(end)){
            start--;
            end++;

        }
        if (max < end - start - 1) {
            low = start + 1;
            max = end - start - 1;
        }
    }
}
