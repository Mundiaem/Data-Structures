package com.practice.datastructures.string;

/*
* Given a string of lowercase letters in the range ascii[a-z], determine the index of a character that can be removed to make the string a palindrome. There may be more than one solution, but any will do. If the word is already a palindrome or there is no solution, return -1. Otherwise, return the index of a character to remove.
Example s= "bcbc"
Either remove b'at index 0 or 'c'at index 3.
Function Description
Complete the palindromeindex function in the editor below. palindromelndex has the following parameter(s):
• strings: a string to analyze
Returns
• int: the index of the character to remove or -1
* */
public class PalindromeIndex {
    private static int palindromeIndex(String s) {
        // If the string is already a palindrome, return -1
        if (isPalindrome(s)) return -1;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                // If removing character at index i would result in a palindrome
                if (isPalindrome(s.substring(0, i) + s.substring(i + 1))) {
                    return i;
                }
                // If removing character at index length -1 -i would result in a palindrome
                if (isPalindrome(s.substring(0, n - 1 - i) + s.substring(n - i))) {
                    return n - 1 - i;
                }
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Sample test cases
        String[] queries = {"aaab", "baa", "aaa"};
        for (String query : queries) {
            System.out.println(palindromeIndex(query));
        }
    }
}
