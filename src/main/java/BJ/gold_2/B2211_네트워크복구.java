package BJ.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class B2211_네트워크복구 {
    static List<List<Node>> graph = new ArrayList<>();
    static int N, M, start;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        parent = new int[N+1];
        start = 1;
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] arr1 = br.readLine().split(" ");
            graph.get(Integer.parseInt(arr1[0])).add(new Node(Integer.parseInt(arr1[1]),Integer.parseInt(arr1[2])));
            graph.get(Integer.parseInt(arr1[1])).add(new Node(Integer.parseInt(arr1[0]),Integer.parseInt(arr1[2])));
        }
        //System.out.println(graph);

        int[] result = bfs(start);

        System.out.println(N-1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i] + " " + i);
        }
    }

    private static int[] bfs(int start) {
        int[] answer = new int[N+1];
        Arrays.fill(answer,Integer.MAX_VALUE);
        answer[start] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a,b)->a.weight-b.weight);
        priorityQueue.add(new Node(start,0));
        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();
            if (now.weight > answer[now.to]) continue;
            for (Node next : graph.get(now.to)){
                if (answer[next.to] > answer[now.to] + next.weight){
                    answer[next.to] = answer[now.to] + next.weight;
                    parent[next.to] = now.to;
                    priorityQueue.add(new Node(next.to,answer[next.to]));
                }
            }
        }
        return answer;
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
