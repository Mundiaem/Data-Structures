package com.practice.datastructures.recursion;

/**
 * 1143. Longest Common Subsequence


 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without
 * changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 */
public class LongestCommonSubsequenceR {
   static StringBuilder sb;
    public static void main(String[] args) {
        String S1 = "abcde";
        String S2 = "ace";
        System.out.println(LCS(S1, S2, S1.length(), S2.length()));


    }
    private static int LCS(String s1, String s2, int m, int n){
     sb= new StringBuilder();

        if (m == 0 || n == 0) {
            return 0;
        } else if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            sb.append(s1.charAt(m-1));
            return 1 + LCS(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(LCS(s1, s2, m, n - 1), LCS(s1, s2, m - 1, n));
        }
    }
    private static int f(String s1, String s2, int index1, int index2){

        if(index1 ==0 || index2==0){
            return 0;
        }else if (s1.charAt(index1)== s2.charAt(index2)){
            sb.append(s1.charAt(index1));
           return 1+ f(s1,s2, (index1-1), (index2-1));
        }else{
           return Math.max(f(s1,s2, (index1-1), index2),f(s1,s2, index1, (index2-1))) ;



        }



    }
}
