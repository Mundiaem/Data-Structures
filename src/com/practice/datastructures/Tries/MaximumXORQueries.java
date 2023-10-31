package com.practice.datastructures.Tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*Explanation:

The code takes a list of integers list and a list of queries  as input.
It rearranges the query list queries to have the form of (value, lowerLimit, queryIndex) where queryIndex is used to identify the query.
The queries are sorted by their value (second element) in ascending order.
It uses a custom TrieXOR data structure to efficiently calculate the maximum XOR value for each query.
The results are stored in a list ans.
*
*
Time Complexity:

Sorting list takes O(NlogN), where N is the size of the list.
Sorting oQ (queries) takes O(QlogQ), where Q is the number of queries.
The for loop iterating through the queries takes O(Q * 32) time, where 32 is the number of bits in an integer.
The while loop processing list elements takes O(N * 32) time.
Overall, the time complexity is O(QlogQ + N * 32 + Q * 32) = O(QlogQ + N + Q).
*
*
*
Space Complexity:

Additional space is used for the oQ list, the ans list, and the TrieXOR data structure.
The space complexity is determined by these additional data structures and can vary depending on their implementation.
* */
public class MaximumXORQueries {
    public static void main(String[] args) {
        // The main method is currently empty, and no code is executed here.
        // You can call the maximumQueries method with appropriate input parameters.
    }

    private static List<Integer> maximumQueries(List<Integer> list, List<List<Integer>> queries) {
        // Sort the input list in ascending order.
        Collections.sort(list);

        // Create a list to store modified queries where elements are rearranged.
        List<List<Integer>> oQ = new ArrayList<>();
        int m = queries.size();

        // Rearrange the queries, changing the order of elements and adding an index.
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(queries.get(i).get(1));
            temp.add(queries.get(i).get(0));
            temp.add(i);
            oQ.add(temp);
        }

        // Sort the modified queries based on the first element (queries.get(i).get(1)).
        // This step helps in processing the queries in a particular order.
        oQ.sort((o1, o2) -> o1.get(0).compareTo(o2.get(0)));

        int index = 0;
        int n = list.size();
        TrieXOR trie = new TrieXOR(); // TrieXOR is assumed to be a custom class.

        // Create a list to store the results of each query.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(-1);
        }

        // Iterate through the queries.
        for (int i = 0; i < m; i++) {
            // Insert elements into the trie until the list element is less than or equal to the query element.
            while (index < n && list.get(index) <= oQ.get(i).get(0)) {
                trie.insert(list.get(index));
                index++;
            }

            int queryIndex = oQ.get(i).get(2);
            if (index != 0) {
                // Calculate the maximum XOR value for the query element using the trie.
                ans.set(queryIndex, trie.getMax(oQ.get(i).get(0)));
            } else {
                ans.set(queryIndex, -1); // Set to -1 if no elements were inserted in the trie.
            }
        }
        return ans;
    }
}

