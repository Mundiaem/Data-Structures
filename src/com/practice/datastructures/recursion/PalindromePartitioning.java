package com.practice.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(solution().toString());
    }
    private static List<List<String>> solution(){
/**
 * Example
 * Input : string s = "aabb"
 * Output =>List<List<String> ans= [{a,a,b,b}
 * {a,a,bb}
 * {aa,b,b}
 * {aa,bb}]
 * f(s, index) { for(index -> n-1) -> i }
 * */
List<List<String>> ans= new ArrayList<>();
List<String> path = new ArrayList<>();
func(0, "aabb", ans, path);


return ans;


    }
    private static void func(int index, String s, List<List<String>>ans, List<String>path){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=index; i<s.length(); i++){
            if(!isPalindrome(s, index, i)) continue;
                path.add(s.substring(index, i+1));
                func(i+1, s, ans, path);
                path.remove(path.size()-1);

        }
    }

    static boolean  isPalindrome(String s, int start, int end){
        while (start<=end){
            if (s.charAt(start++)!= s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
