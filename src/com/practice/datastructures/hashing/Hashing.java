package com.practice.datastructures.hashing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashing {
    public static void main(String[] args) throws FileNotFoundException {

        // hashingIntegers();
       // hashingStrings();
        hashingUsingMap();


    }

    private static void hashingIntegers() throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("src/com/practice/datastructures/hashing/input.txt"));
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int[] hash = new int[13];
        Arrays.fill(hash, 0);

        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q = input.nextInt();
        while (q > 0) {
            int number = input.nextInt();
            System.out.println(hash[number]);

            q--;
        }
    }

    private static void hashingStrings() throws FileNotFoundException {
        String s;
        Scanner input = new Scanner(new FileReader("src/com/practice/datastructures/hashing/input-string.txt"));
        s = input.nextLine();
        int q= input.nextInt();
        int [] hashing= new int[26];
        for(int i=0; i<s.length(); i++ ){
            hashing[s.charAt(i)-'a']++;
        }
        while (q>0){
            char c;
            c= input.next().charAt(0);
            q--;
            System.out.println(hashing[c-'a']);

        }

    }
    /**
     * Time Complexity
     * O(N+N)
     * */
    private static void hashingUsingMap() throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("src/com/practice/datastructures/hashing/input.txt"));
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
       Map<Integer, Integer> map= new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1 );
        }

        int q = input.nextInt();
        while (q > 0) {
            int number = input.nextInt();
            System.out.println(map.get(number));

            q--;
        }
    }

}
