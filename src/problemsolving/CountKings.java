package problemsolving;

import java.util.*;

public class CountKings {

    static class Node {
        int city;
        int royalty;
        List<Node> children;

        Node(int city, int royalty) {
            this.city = city;
            this.royalty = royalty;
            this.children = new ArrayList<>();
        }
    }

    static int[] count_kings(int N, int Q, int[] royalty, int[] road, int[] capacity, int[] query) {
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, royalty[i - 1]);
        }

        for (int i = 0; i < N - 1; i++) {
            int u = i + 2;
            int v = road[i];
            nodes[u].children.add(nodes[v]);
        }

        int[] ans = new int[Q];
        for (int i = 0; i < Q; i++) {
            int day = query[i];

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.royalty, a.royalty));
            pq.add(nodes[1]);

            while (day > 0) {
                List<Node> nextDay = new ArrayList<>();
                while (!pq.isEmpty()) {
                    Node current = pq.poll();
                    for (Node child : current.children) {
                        if (capacity[child.city - 1] > 0) {
                            nextDay.add(child);
                            capacity[child.city - 1]--;
                        }
                    }
                }
                pq.addAll(nextDay);
                day--;
            }

            ans[i] = pq.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 4;
        int[] royalty = {4, 1, 3, 2};
        int[] road = {1, 2, 2};
        int[] capacity = {1, 1, 1};
        int Q = 4;
        int[] query = {2, 1, 5, 3};

        int[] result = count_kings(N, Q, royalty, road, capacity, query);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}


