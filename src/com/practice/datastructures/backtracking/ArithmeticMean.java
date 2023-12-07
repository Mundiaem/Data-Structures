package com.practice.datastructures.backtracking;

public class ArithmeticMean {

    public static int solution(int[] A, int S) {
        int[] count = {0}; // To store the count of fragments with arithmetic means equal to S
        backtrack(A, S, 0, 0, 0, count);
        return Math.min(count[0], 1_000_000_000); // Cap the result if it exceeds 1,000,000,000
    }

    private static void backtrack(int[] A, int S, int start, int sum, int length, int[] count) {
        if (start == A.length) {
            if (length != 0 && sum * 1.0 / length == S) {
                count[0]++;
            }
            return;
        }

        // Calculate the sum and count for the current fragment
        int currSum = 0;
        int currCount = 0;

        for (int i = start; i < A.length; i++) {
            currSum += A[i];
            currCount++;

            if (currSum * 1.0 / currCount == S) {
                count[0]++;
            }
        }

        // Exclude the current element from the fragment
        backtrack(A, S, start + 1, sum, length, count);
    }

    public static void main(String[] args) {
        int [] A= {2,1,3};
        int [] A2= {0,4,3,-1};
        int [] A3= {2,1,4};


        int S=2;
        int S2=2;
        int S3=3;


        System.out.println(solution(A,S));
        System.out.println(solution(A2,S2));
        System.out.println(solution(A3,S3));


    }
}
