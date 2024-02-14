package com.practice.datastructures.string;

import java.util.Arrays;

public class CountStringPermutations {

   static int MOD = (int)(1e9 + 7);

    public static int countVowelPermutation(int n) {
        return (int)findPerm(n, 0);
    }

    private static long findPerm(int len, int last) {
        if (len == 0)
            return 1;

        long count = 0;
        if (last == 2)
            count = (count + findPerm(len - 1, 1)) % MOD;
        if (last == 1 || last == 3)
            count = (count + findPerm(len - 1, 2)) % MOD;
        if (last != 0 && last != 3)
            count = (count + findPerm(len - 1, 3)) % MOD;
        if (last == 5 || last == 3)
            count = (count + findPerm(len - 1, 4)) % MOD;
        if (last == 1)
            count = (count + findPerm(len - 1, 5)) % MOD;
        if (last == 0)
            for (int i = 1; i <= 5; i++)
                count = (count + findPerm(len - 1, i)) % MOD;

        return count % MOD;
    }
    static int countPerms(int n) {
        long MOD = (long)(1e9 + 7);
        long[] dpLast = new long[6];
        Arrays.fill(dpLast, 1);
        for (int len = 1; len <= n; len++) {
            long[] dpCurr = new long[6];
            for (int last = 0; last <= 5; last++) {
                long count = 0;
                if (last == 2)
                    count = (count + dpLast[1]) % MOD;
                if (last == 1 || last == 3)
                    count = (count + dpLast[2]) % MOD;
                if (last == 1 || last == 2 || last == 4 || last == 5)
                    count = (count + dpLast[3]) % MOD;
                if (last == 3 || last == 5)
                    count = (count + dpLast[4]) % MOD;
                if (last == 1)
                    count = (count + dpLast[5]) % MOD;
                if (last == 0)
                    for (int i = 1; i <= 5; i++)
                        count = (count + dpLast[i]) % MOD;

                dpCurr[last] = count;
            }
            dpLast = dpCurr;
        }
        return (int)dpLast[0];
    }
    static int changeAds(int base10) {
        // Convert base10 to binary string
        if (base10 == 0) {
            return 1; // Special case: 0 should be treated as 1
        }

        // Find the highest order 1 bit and negate the bits from that position onward
        int mask = Integer.highestOneBit(base10) << 1 - 1;
        int result = base10 ^ mask;


        return result;
    }
    public static void main(String[] args) {
//        int n1 = 1;
//        int n2 = 2;
//        int n3 = 3;

//
//        System.out.println(countPerms(n1)); // Output: 5
//
//        System.out.println(countPerms(n2)); // Output: 5
//        System.out.println(countPerms(n3)); // Output: 5
        int base10_1 = 50;
        int base10_2 = 100;

        System.out.println(changeAds(base10_1)); // Output: 13
        System.out.println(changeAds(base10_2)); // Output: 27
    }
}
