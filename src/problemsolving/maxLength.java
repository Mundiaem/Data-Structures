package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/?envType=daily-question&envId=2024-01-23
public class maxLength {

    public static void main(String[] args) {
//        List<String> list = List.of("un", "iq", "ue");
//        System.out.println(maxLength(list));
        // Test cases
        System.out.println(countDuplicates("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix"));  // Output: 26
        System.out.println(countDuplicates("abcdeaBReturnsTwo"));  // Output: 2

    }
    public static int countDuplicates(String inputStr) {
        // Convert the input string to lowercase to make it case-insensitive
        String inputStrLower = inputStr.toLowerCase();

        // Initialize a Map to store the count of each character
        Map<Character, Integer> charCount = new HashMap<>();

        // Iterate through each character in the input string
        for (char c : inputStrLower.toCharArray()) {
            // Increment the count for the current character in the Map
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count the number of characters that occur more than once
        long duplicatesCount = charCount.values().stream().filter(count -> count > 1).count();

        return (int) duplicatesCount;
    }
    private static int maxLength(List<String> list) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;
        for (String s : list) {
            int a = 0, dup = 0;
            for (char c : s.toCharArray()) {
                dup |= a & (1 << (c - 'a'));
                a |= 1 << (c - 'a');
            }
            if (dup > 0) continue;
            for (int i = dp.size() - 1; i >= 0; i--) {
                if ((dp.get(i) & a) > 0) continue;
                dp.add(dp.get(i) | a);
                res = Math.max(res, Integer.bitCount(dp.get(i) | a));
            }
        }

        return res;


    }
}
