package com.practice.datastructures.arrays;

/*
* Problem Explanation:
Given two arrays of integers a and b, we need to find the count of integers that satisfy two conditions:
All integers are factors of the numbers in array a.
All integers are multiples of the numbers in array b.
Approach to Solve:
Find Factors of the LCM of Array a:
Calculate the LCM (Least Common Multiple) of all elements in array a. This LCM will be the smallest number that satisfies condition 1 for array a.
Find all the factors of this LCM. These factors will satisfy condition 1.
Find Multiples of the GCD of Array b:
Calculate the GCD (Greatest Common Divisor) of all elements in array b. This GCD will be the largest number that satisfies condition 2 for array b.
Find all the multiples of this GCD. These multiples will satisfy condition 2.
Count Numbers That Satisfy Both Conditions:
Compare the two sets of numbers obtained in steps 1 and 2.
Count how many numbers are common between these sets. These are the numbers that satisfy both conditions simultaneously.
* */
public class BetweenTwoSets {

    public static void main(String[] args) {

    }
}
