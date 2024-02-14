package com.practice.datastructures.string;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /****
     * Approach
     * Use sliding window with hashset, use left and right pointers to move the window .
     * If the set doesn't contains character then first add into the set and calculate the maxLength hand-in-hand...
     * if character already present in the set that means you have to move your sliding window by 1 , before that you have to remove all the characters that are infront of the character that is present already in window before.
     * Now you have to remove that character also and move the left pointer and also add the new character into the set.
     * THAT'S ALL........EASY APPROACH USING SIMPLE HASHSET+SLIDING WINDOW
     * Complexity
     * Time complexity: O(n)
     * Space complexity: O(k), where k is the number of distinctive characters prsent in the hashset.
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "bbbbb";
        String s2 = "pwwkew";
        String s4 = "au";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /***
     *
     * @param  s
     * @return int ans
     */
    public static int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ans = Math.max(ans, right - left + 1);
            } else {
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(right));
            }

        }


        return ans;

    }
}
