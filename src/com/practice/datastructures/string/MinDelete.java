package com.practice.datastructures.string;
/**
 *
 *
 * ### Problem Overview:
 * Given an array of strings `strs`, the goal is to determine the minimum number of deletion indices required so that the strings are in lexicographic order when compared column-wise.
 *
 * ### Approach Explanation:
 *
 * 1. **`minDeletionSize` Function:**
 *    - This function takes in an array of strings (`strs`) and calculates the minimum number of deletion indices needed to achieve lexicographic order.
 *
 * 2. **Iterating Through Columns:**
 *    - The outer loop (`for` loop) iterates through each column of the strings.
 *    - `strs[0].length()` represents the length of each string in the array. So, `for (int col = 0; col < strs[0].length(); col++)` iterates through each column index.
 *
 * 3. **Checking Lexicographic Order:**
 *    - The inner loop (`for` loop) traverses through the strings starting from the second string (`i = 1`) up to the last string (`strs.length - 1`).
 *    - For each column, it compares consecutive characters in the strings at the same column index.
 *    - `strs[i - 1].charAt(col) > strs[i].charAt(col)` compares the characters in the current column between two consecutive strings.
 *    - If a character in the previous string is greater than the character in the next string at the same column, it means the current column needs to be deleted to achieve lexicographic order.
 *    - When this condition is met, it increments the `deletionCount` and breaks out of the inner loop to move to the next column.
 *
 * 4. **Return the Deletion Count:**
 *    - The function returns the final count of deletion indices (`deletionCount`), which represents the minimum number of columns that need to be deleted to ensure the strings are in lexicographic order.
 *
 * 5. **`main` Method:**
 *    - The `main` method is used to demonstrate the usage of the `minDeletionSize` function with a sample input (`strs = {"xc", "yb", "za"}`).
 *    - It calls the `minDeletionSize` function with the given input array and prints the resulting output.
 *
 * ### Example Execution:
 *
 * Given the input `strs = {"xc", "yb", "za"}`:
 * - The function `minDeletionSize` iterates through each column:
 *   - Column 0: All characters ('x', 'y', 'z') are already in lexicographic order, so no deletion needed.
 *   - Column 1: All characters ('c', 'b', 'a') are in lexicographic order, so no deletion needed.
 * - As a result, the function returns `0` because no deletion is required to achieve lexicographic order.
 *
 * This code works by systematically iterating through columns and comparing characters in consecutive strings to determine the minimum number of deletions needed for lexicographic order.
 *
 *The time and space complexity of the provided solution are as follows:
 *
 * ### Time Complexity:
 * - The outer loop (`for` loop) iterates through each column of the strings. It iterates `strs[0].length()` times.
 * - The inner loop (`for` loop) traverses through the strings for each column. It iterates `strs.length - 1` times.
 * - Therefore, the time complexity of the solution is O(n * m), where:
 *   - 'n' is the number of strings in the array (`strs.length`).
 *   - 'm' is the length of each string (`strs[0].length()`).
 *
 * ### Space Complexity:
 * - The space complexity of the solution is O(1) because the algorithm uses a constant amount of extra space regardless of the input size.
 * - It does not use any additional data structures or allocate memory that scales with the input size. The extra space used is only for variables like `deletionCount`, loop counters, and temporary string comparisons, which do not depend on the input size.
 *
 * In summary, the solution has a time complexity of O(n * m) and a space complexity of O(1), where 'n' is the number of strings and 'm' is the length of each string in the input array `strs`.
 * */
public class MinDelete {
    public static int minDeletionSize(String[] strs) {
        int deleteCount=0;
        int n=strs.length;
        int col, index;
        boolean[] sorted= new boolean [n+1];
        for( col=0; col<strs[0].length(); col++){
            for(index=0; index<n-1; index++){
                if(!sorted[index]&& strs[index].charAt(col)>strs[index+1].charAt(col)){
                    deleteCount++;
                    break;

                }
            }
            if(index<n-1) continue;
            for(index=0; index<n-1; ++index ){
                sorted[index] |=strs[index].charAt(col)< strs[index+1].charAt(col);
            }
        }
        return deleteCount;


    }

    public static void main(String[] args) {
        String[] strs1 = {"ca", "bb", "ac"};
        System.out.println("Output for strs1: " + minDeletionSize(strs1)); // Output: 1

        String[] strs2 = {"xc", "yb", "za"};
        System.out.println("Output for strs2: " + minDeletionSize(strs2)); // Output: 0

        String[] strs3 = {"zyx", "wvu", "tsr"};
        System.out.println("Output for strs3: " + minDeletionSize(strs3)); // Output: 3
         }
}
