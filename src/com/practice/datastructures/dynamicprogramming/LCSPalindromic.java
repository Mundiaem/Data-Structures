package com.practice.datastructures.dynamicprogramming;

import java.util.Arrays;

public class LCSPalindromic {
    private static int palindromeSubstring(String s, String newS){
        int n= s.length(), m= newS.length();
        int [][] dp = new int[n+1][m+1];

        for (int i = 0; i <=n; i++) dp[i][0]=0;
        for (int i = 0; i <=m; i++) dp[0][i]=0;
        for (int index1 = 1; index1 <=n ; index1++) {
            for (int index2 = 1; index2 <=m; index2++) {
                if (s.charAt(index1-1)== newS.charAt(index2-1)){
                    dp[index1][index2] = 1+ dp[index1-1][index2-1];
                }else{
                    dp[index1][index2]= Math.max(dp[index1-1][index2],dp[index1][index2-1]);
                }
            }

        }
        return dp[n][m];


    }
    private static int longestCommonPalindrome(String s){
        String newS= new StringBuilder(s).reverse().toString();
        return palindromeSubstring(s, newS);
    }
    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.println(longestCommonPalindrome(s));
        int N = 5;
        String S = "abcdc";
        int result = minRemovals(S);
        System.out.println("Minimum length of substring to remove: " + result);
    }

        public static int minRemovals(String s) {
            int[] charCount = new int[26];
            int oddCount = 0;

            // Count the occurrences of each character in the string
            for (char ch : s.toCharArray()) {
                charCount[ch - 'a']++;
            }

            // Count the number of characters with odd occurrences
            for (int count : charCount) {
                if (count % 2 != 0) {
                    oddCount++;
                }
            }

            // If the string is already a palindrome, no removal needed
            if (oddCount <= 1) {
                return 0;
            }

            // Calculate the minimum removals required
            return oddCount - 1;
        }
}
