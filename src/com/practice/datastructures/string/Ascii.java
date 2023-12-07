package com.practice.datastructures.string;

import java.util.Arrays;

import static java.lang.Math.floor;
import static java.lang.Math.log;

public class Ascii {
    public static void main(String[] args) {
        int N = 11;
        System.out.println(longestString(N));


        int N2 = 1;
        System.out.println(longestString(N2));

        int N3 = 67108876;
        System.out.println(longestString(N3));

    }

    private static String longestString(int N) {
        // Initialize a StringBuilder tox build the resulting string.
        StringBuilder result = new StringBuilder();


        // Initialize quotient and remainder to keep track of the number of transformations.
        int quotient = N / 2;
        int remainder = N % 2;

        // Initialize the current character as 'a'.
        char current = 'a';

        // If there's a remainder, append the current character to the result.
        if (remainder > 0) {
            result.append(current);
        }


        // While N is greater than 1, perform transformations.
        while (quotient >= 1) {

            // Check if the current character is 'z'. If so, append it to the result and decrement N.
            if ('z' == current) {
                result.append(current);
            } else {
                // Increment the character to the next in the alphabet.
                int charInt = current;
                charInt++;
                current = (char) charInt;
            }

            // Update quotient and remainder for the next iteration.
            remainder = quotient % 2;
            quotient = quotient / 2;
            // If there's a remainder, append the current character to the result.
            if (remainder > 0) {
                result.append(current);
            }
        }

        // Reverse the result and convert it to a string.
        return result.reverse().toString();
    }

}
