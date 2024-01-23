package problemsolving;

import java.util.ArrayList;
import java.util.List;
/*
*
* 1. Rotate Array: https://lnkd.in/gmNmR_GM

2. Longest Common Subsequence: https://lnkd.in/gn_niUMG

3. Permutations: https://lnkd.in/gkfWBuk8

4. Two Sum: https://lnkd.in/gwqAHr8h

5. Merge Intervals: https://lnkd.in/gbFQ-BX9

*
* */
public class MinimumBribes {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes=0;
        int lowest= q.get(q.size()-1);
        for(int i= q.size()-2; i>=0; i--){
            int offset= q.get(i) - (i+1);
            // if the  offset is too large print "Too Chaotic"
            if(offset > 2){
                System.out.println("Too chaotic");
                return;
            }else if(q.get(i)> lowest&& offset <1){
                bribes +=1;
            }else if(q.get(i)< lowest){
                lowest=q.get(i);
            }else {
                bribes +=offset;
            }

        }
        System.out.println(bribes);

    }

    public static void main(String[] args) {
        List<Integer> myList= new ArrayList<>(List.of(2, 1, 5, 3, 4));
        minimumBribes(myList);

    }
}
