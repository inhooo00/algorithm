package BJ.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class B1167_트리의지름 {
    static int V;
    static List<List<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        for (int i = 0; i<= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= V; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int idx = 1;
            while (idx < input.length && !input[idx].equals("-1")) {
                int to = Integer.parseInt(input[idx]);
                int weight = Integer.parseInt(input[idx + 1]);
                graph.get(from).add(new Node(to, weight));
                idx += 2;
            }
        }
        int startNum = 0;
        int maxNum = 0;
        visited = new boolean[V+1];
        int[] dis =bfs(1);
        for (int i = 1; i < V+1; i++) {
            if (maxNum < dis[i]){
                maxNum = dis[i];
                startNum = i;
            }
        }
        visited = new boolean[V+1];
        int[] result = bfs(startNum);
        Arrays.sort(result);
        System.out.println(result[result.length-1]);
    }

    private static int[] bfs(int startNum) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(startNum);
        visited[startNum] = true;
        int[] distance = new int[V+1];

        while (!deque.isEmpty()){
            int now = deque.remove();
            for(Node g : graph.get(now)){
                if (!visited[g.num]){
                    visited[g.num] = true;
                    deque.add(g.num);
                    distance[g.num] = distance[now] + g.weight;
                }
            }
        }
        return distance;
    }

    public static class Node{
        int num;
        int weight;
        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
}
