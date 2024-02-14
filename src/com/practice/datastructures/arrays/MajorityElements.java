package com.practice.datastructures.arrays;

public class MajorityElements {
    public static void main(String[] args) {
        int[] nums = {2,4,5,5,5,5,5,6,6};
        System.out.println(boyenMooreVotingAlgorithm(nums));
    }

    private static int bitManipulation(int[] nums) {
        int n = nums.length;
        /**
         * Using bit manipulation approach
         * Solution idea
         * As given in the problem, we know that there is a majority element in the array. Can we use mathematical insights from the binary representation of the numbers to find the majority element? Let's think.
         * Suppose each element is a 32-bit integer. Now, for all numbers, we count the frequency of set bits (l's) at each bit position in the bitwise representation (It's like polling for each bit position). At any position in the bitwise representation:
         * • If the frequency of 1's is in the majority (greater than n/2), then the bit value at the same position in the majority element will be 1.
         * • If the frequency of 1's is not in the majority (less than n/2), then the bit value at the same position in the majority element will be 0.
         * For example, X|1 = 16, 13, 13, 2, 131, n = 5.
         *
         * 6
         * =>
         * 01 1 0
         * 13
         * =>
         * 1101
         * 13 →>
         * 1101
         * 2
         * 0 0 10
         * 13 ->
         * 1101
         *
         * Majority = 1 1 0 1 = 13
         *
         * In the above example, I's are in the majority at the 1st, 2nd, and 4th positions, so the set bits at the same positions in the majority element will be 1. At the 3rd position, the number of I's across all array elements is only 2, which is not a majority. So, the bit value at the 3rd position in the majority element will be 0.
         * The idea is simple: By identifying the majority bits at every bit position for all the numbers, we can construct the majority element bitwise. How can we implement it? Let's think!
         * Solution steps
         * Step 1: We initialize a variable to store the majority element, i.e., majorityElement = 0. Initially, all bits in
         * majorityElement would be 0.
         * Step 2: Now we run a loop from currBit = 0 to 31, where the loop variable currBit represents the current bit position
         * of a 32-bit integer.
         * • For each bit position, we initialize a variable to count the frequency of 1's, i.e., countOnes = 0.
         * Now we iterate over the entire array and increase countOnes by 1 if the current bit position is 1 in an element.
         */
        int majorityElement = 0;
        for (int bit = 0; bit < 32; bit++) {
            int countOnes = 0;
            for (int i = 0; i < n; i++) {
                countOnes += (nums[i] >> bit) & 1;
            }
            if (countOnes > n / 2) {
                majorityElement |= (1 << bit);
            }
        }
        return majorityElement;


    }

    private static int boyenMooreVotingAlgorithm(int[] nums) {
        /**
         * The intuition behind Boyer-Moore Voting algorithm: Since the majority element appears more than n/2 times, its frequency is greater than the combined frequency of all the other elements. So, if we mark the occurrence of the majority element as +1 and the occurrence of any other element as -1, then the overall sum of these markings would definitely be greater than zero.
         * Here is another interesting analogy to understand this algorithm: Suppose there are n people, each holding one element of the array. Whenever two people meet who do not hold the same array element as the other, they sit down. Eventually, if anyone is left standing, that person is holding the majority element.
         * Note: As long as the majority element occurs with a frequency of at least n/2, we can guarantee that this approach will always find the majority element.
         * Solution steps
         * 1. To keep track of our current guess of the majority element, we declare a variable majorityCandidate and maintain a counter variable count. Initially, the value of both variables is equal to 0.
         * 2. Let's walk across the array. If the current element matches our guess, we increment the count by 1. If the current element doesn't match our guess, we decrement the count by 1.
         * 3. If count == 0, we reset the current guess and make it equal to the current element, i.e., majorityCandidate = Xi). In other words, we forget about everything up to the previous index and consider the current element as a potential candidate for the majority element.
         * 4. By the end of the loop, the value of the majority element gets stored in the variable majorityCandidate.
         * There are many ways to think about why this algorithm works. One good intuition is to think of this algorithm as breaking the input into a chunk of consecutive copies of a particular value.
         * The intuition behind Boyer-Moore Voting algorithm: Since the majority element appears more than n/2 times, its frequency is greater than the combined frequency of all the other elements. So, if we mark the occurrence of the majority element as +1 and the occurrence of any other element as -1, then the overall sum of these markings would definitely be greater than zero.
         * Here is another interesting analogy to understand this algorithm: Suppose there are n people, each holding one element of the array. Whenever two people meet who do not hold the same array element as the other, they sit down. Eventually, if anyone is left standing, that person is holding the majority element.
         * Note: As long as the majority element occurs with a frequency of at least n/2, we can guarantee that this approach will always find the majority element.
         * Solution steps
         * 1. To keep track of our current guess of the majority element, we declare a variable majorityCandidate and maintain a counter variable count. Initially, the value of both variables is equal to 0.
         * 2. Let's walk across the array. If the current element matches our guess, we increment the count by 1. If the current element doesn't match our guess, we decrement the count by 1.
         * 3. If count == 0, we reset the current guess and make it equal to the current element, i.e., majorityCandidate = Xi). In other words, we forget about everything up to the previous index and consider the current element as a potential candidate for the majority element.
         * 4. By the end of the loop, the value of the majority element gets stored in the variable majorityCandidate.
         * There are many ways to think about why this algorithm works. One good intuition is to think of this algorithm as breaking the input into a chunk of consecutive copies of a particular value.
         */
        int n = nums.length;
        int count = 0;
        int majorityElement = 0;
        for (int i = 0; i < n; i++) {

            if (count == 0) majorityElement = nums[i];
            if (nums[i] == majorityElement) {
                count++;
            } else {
                count--;
            }

        }

        return majorityElement;
    }
}
