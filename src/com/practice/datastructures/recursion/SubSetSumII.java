package com.practice.datastructures.recursion;

import java.util.*;

/**
 * created with love by mundiaem
 * created on 12/12/2022
 * Time: 08:05
 * ⚡  - Data-Structures
 */

public class SubSetSumII {
/*
* Example 1:

Input: array[] = [1,2,2]

Output: [ [ ],[1],[1,2],[1,2,2],[2],[2,2] ]

Explanation: We can have subsets ranging from  length 0 to 3. which are listed above. Also the subset [1,2] appears twice but is printed only once as we require only unique subsets.

Input: array[] = [1]

Output: [ [ ], [1] ]

Explanation: Only two unique subsets are available
*
* */

    /*
*  *** ---- Approach 1 ----  ***
* The unique subsets are
[ [ ][ 1 ][ 1 2 ][ 1 2 2 ][ 2 ][ 2 2 ] ]

Time Complexity: O( 2^n *(k log (x) )). 2^n  for generating every subset and k* log( x)
*  to insert every combination of average length k in a set of size x. After this,
* we have to convert the set of combinations back into a list of list /vector of vectors which takes more time.

Space Complexity:  O(2^n * k) to store every subset of average length k.
* Since we are initially using a set to store the answer another O(2^n *k) is also used.
* */

    private static void func(int index, int[] arr, List<Integer> ds, Set<String> res) {
        if(index==arr.length){
            Collections.sort(ds);
            System.out.println(" ds index==arr.length "+ ds);
            res.add(ds.toString());
            System.out.println(" res "+ res);
            return;
        }

        ds.add(arr[index]);
        System.out.println(" After add "+ ds);
        func(index+1, arr, ds, res);
        ds.remove(ds.size()-1);
        System.out.println(" After remove "+ ds);
        func(index+1, arr, ds, res);
    }

    private static List<String> subSetWithDup(int[] arr) {
        int index=0;
        Set<String> res= new HashSet<>();
        List<String> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();

        func(index, arr, ds,res );
        for (String it: res){
            ans.add(it);
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] arr= new int[]{1,2,2};

        System.out.println(subSetWithDup(arr));

    }




}
