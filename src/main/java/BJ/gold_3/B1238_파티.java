package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class B1238_파티 {
    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverseGraph = new ArrayList<>();
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]); // 정점
        M = Integer.parseInt(arr[1]); // 간선
        X = Integer.parseInt(arr[2]); // 목적지

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            graph.get(from).add(new Node(to, weight));
            reverseGraph.get(to).add(new Node(from, weight));
        }

        int[] distFromX = dijkstra(X, graph);
        int[] distToX = dijkstra(X, reverseGraph);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, distToX[i] + distFromX[i]);
        }

        System.out.println(answer);
    }

    static private int[] dijkstra(int start, List<List<Node>> g) {
        int[] result = new int[N + 1];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[start] = 0;

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a,b)->a.weight-b.weight);
        priorityQueue.add(new Node(start,0));

        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();
            if (now.weight > result[now.to]) continue;
            for(Node next : g.get(now.to)){
                if (result[next.to]> next.weight + result[now.to]){
                    result[next.to] = next.weight + result[now.to];
                    priorityQueue.add(new Node(next.to,result[next.to]));
                }
            }
        }
        return result;
    }

    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
