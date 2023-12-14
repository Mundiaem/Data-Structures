package com.practice.datastructures.recursion;

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
