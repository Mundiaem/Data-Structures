package com.practice.datastructures.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
private static List<Integer> findAllAnagram(String s, String p){
    List<Integer> ans = new ArrayList<>();

        int[] arr1= new int [26];
        int [] arr2= new int[26];
        int n= s.length(), m= p.length();

        if(m>n) return ans;

        for(int i=0; i<m; i++){
            arr1[p.charAt(i) - 'a']++;
            arr2[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(arr1, arr2)) ans.add(0);

        for(int i=m; i<n; i++){
            arr2[s.charAt(i) - 'a']++;
            arr2[s.charAt(i - m) - 'a']--;
            if(Arrays.equals(arr1, arr2)) ans.add(i - m +1);
        }
        return  ans;
}

    public static void main(String[] args) {
       String s = "cbaebabacd";
       String p = "abc";
       System.out.println(findAllAnagram(s, p));



    }
}
