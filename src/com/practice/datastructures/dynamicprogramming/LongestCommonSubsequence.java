package com.practice.datastructures.dynamicprogramming;

//https://www.javatpoint.com/longest-common-subsequence
public class LongestCommonSubsequence {
    public static void main(String[] args) {

        String S1 = "abcde";
        String S2 = "ace";
        System.out.println(LCM(S1, S2));
    }

    private static String LCM(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                }
            }
        }

        int i = m, j = n;
        int index = dp[m][n];
        StringBuilder sb = new StringBuilder(index + 1);


        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                j--;
                i--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }

        }
        System.out.println(dp[m][n]);
        return sb.reverse().toString();


    }

}
