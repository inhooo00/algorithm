package programmers.p;

import java.util.*;

class P72413 {

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        int[] fromS = dijkstra(s, n, graph);
        int[] fromA = dijkstra(a, n, graph);
        int[] fromB = dijkstra(b, n, graph);


        int minFare = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (fromS[i] == Integer.MAX_VALUE || fromA[i] == Integer.MAX_VALUE || fromB[i] == Integer.MAX_VALUE)
                continue;

            int totalFare = fromS[i] + fromA[i] + fromB[i];
            minFare = Math.min(minFare, totalFare);
        }

        return minFare;
    }

    // Dijkstra 구현
    private int[] dijkstra(int start, int n, List<List<Node>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.to]) continue;

            for (Node next : graph.get(current.to)) {
                int nextCost = dist[current.to] + next.cost;
                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }

        return dist;
    }
}

