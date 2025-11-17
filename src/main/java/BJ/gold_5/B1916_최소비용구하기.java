package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// node에다가 cost 값을 누적해서 관리하고, visited 대신 dist로 각 칸의 최소비용을 관리
public class B1916_최소비용구하기 {
    static int N,M;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(input2[0])).add(new Node(Integer.parseInt(input2[1]),Integer.parseInt(input2[2])));
        }
        String[] goal = br.readLine().split(" ");
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        priorityQueue.add(new Node(Integer.parseInt(goal[0]),0));
        dist[Integer.parseInt(goal[0])] = 0;
        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();
            if (now.to == Integer.parseInt(goal[1])) {
                System.out.println(dist[now.to]);
                System.exit(0);
            }
            for(Node n : graph.get(now.to)){
                if (dist[now.to]+n.cost< dist[n.to]){
                    dist[n.to] = dist[now.to]+n.cost;
                    priorityQueue.add(new Node(n.to,dist[now.to]+n.cost));
                }
            }
        }
    }

    static class Node{
        int to,cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
}
