package com.practice.datastructures.string;

import java.util.HashSet;
import java.util.Set;

public class NamingCompany {
    public static void main(String[] args) {
        String[] input = {"coffee","donuts","time","toffee"};
        System.out.println(distinctNames(input));




    }
    public static long distinctNames(String[] ideas) {
        /**
         Intuition
         - only words that

         */
        long ans=0;
        //Group string by initials
        Set[] suffixes = new Set[26];

        for(int i=0; i<26; i++){
            suffixes[i]= new HashSet<>();
        }

        for(String idea: ideas){
            suffixes[idea.charAt(0)- 'a'].add(idea.substring(1));
        }
        for(int i=0; i<25; i++){
            for(int j=i; j<26; j++){
                int count =0;

                for(Object suffix: suffixes[i]){
                    if(suffixes[j].contains(suffix)){
                        count++;
                    }
                }
                ans += 2L *(suffixes[i].size() - count) * (suffixes[j].size() - count);

            }
        }

        return ans;
    }
}
