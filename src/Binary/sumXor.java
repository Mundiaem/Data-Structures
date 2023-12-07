package Binary;

/**
 *
 * The problem is to find the count of values \(x\) that satisfy the equation \(n + x = n \oplus x\) for a given number \(n\).
 * The bitwise XOR operation \(\oplus\)
 * compares corresponding bits of two numbers and returns 1 if the bits are different, otherwise returns 0.
 *
 * The approach used in the code is to count the number of trailing zeros in the binary representation of the input number \(n\).
 * This is done by shifting the bits of \(n\) to the right and checking if the rightmost bit is 0.

 *
 * Explanation of the `sumXor` method:
 *
 * 1. `zeroBits` is initialized to 0. This variable will store the count of trailing zeros.
 * 2. The `while` loop continues until the number \(n\) becomes zero.
 * 3. Inside the loop:
 *    - The expression `(n & 1) == 0` checks if the rightmost bit of \(n\) is 0. If it is 0, it means there is a trailing zero, so `zeroBits` is incremented.
 *    - `n >>= 1` shifts all bits of \(n\) one position to the right, effectively checking the next bit in the next iteration of the loop.
 * 4. After the loop finishes, `zeroBits` holds the count of trailing zeros in the binary representation of \(n\).
 * 5. Finally, the method returns \(2^\text{{zeroBits}}\), as the count of values satisfying the equation is \(2^\text{{zeroBits}}\). This is because for each trailing zero in \(n\), there are two possibilities (0 or 1) for the corresponding bit in \(x\) that will satisfy the equation.
 *
 * The `main` method demonstrates how to use the `sumXor` method by providing a sample input and printing the count of values that satisfy the criteria for that input number.*/
public class sumXor {

    public static long sumXOr(long n) {
        int zeroBits = 0;

        // Loop through the bits of 'n' to count the number of trailing zeros
        while (n != 0) {
            // Check if the rightmost bit is 0
            if ((n & 1) == 0) {
                zeroBits++;
            }
            // Shift 'n' to the right to move to the next bit
            n >>= 1;
        }

        // Return the count of values satisfying the criteria
        return (long) Math.pow(2, zeroBits);
    }

    public static void main(String[] args) {

        // Example usage:
        long number = 4; // Sample input

        System.out.println("Number of values satisfying the criteria for " + number + ": " + sumXOr(number));
    }
}
