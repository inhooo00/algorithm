package BJ.gold_1;

// 간선 제한해서 지연 시간 구하기.... 아예 못나가게 하면 -1.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class B2307_도로검문 {
    static int N,M;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;
    static int[] prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N+1];
        prev = new int[N + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            graph.get(Integer.parseInt(input2[0])).add(new Node(Integer.parseInt(input2[1]),Integer.parseInt(input2[2])));
            graph.get(Integer.parseInt(input2[1])).add(new Node(Integer.parseInt(input2[0]),Integer.parseInt(input2[2])));
        }

       // 최소 거리 - (간선 하나 제한 후 최소 거리) = 최대 값. 즉 가장 유의미한 간선을 삭제해야함.
        dist[1] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a,b)->a.cost - b.cost);
        priorityQueue.add(new Node(1,0));

        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();
            if (now.num==N) {
                break;
            }
            for(Node n : graph.get(now.num)){
                if (dist[n.num] > dist[now.num]+n.cost){
                    dist[n.num] = dist[now.num]+n.cost;
                    prev[n.num] = now.num; // 역추적
                    priorityQueue.add(new Node(n.num,dist[now.num]+n.cost));
                }
            }
        }

        List<Edge> edges = new ArrayList<>();
        /*
         * 역추적 로직 첨 써봄
         */
        int cur = N;
        while (cur != 1) {
            int from = prev[cur];
            int to = cur;
            edges.add(new Edge(from, to));
            cur = from;
        }

        int max = Integer.MIN_VALUE;
        for (Edge e : edges){
            int[] newDist = new int[N+1];
            Arrays.fill(newDist, Integer.MAX_VALUE);
            List<List<Node>> copyGraph = new ArrayList<>();
            for(List<Node> adj : graph){
                List<Node> newList = new ArrayList<>();
                for (Node n : adj) {
                    newList.add(new Node(n.num, n.cost));
                }
                copyGraph.add(newList);
            }

            copyGraph.get(e.from).removeIf(n -> n.num == e.to);
            copyGraph.get(e.to).removeIf(n -> n.num == e.from);

            PriorityQueue<Node> priorityQueue1 = new PriorityQueue<>((a,b)->a.cost-b.cost);
            newDist[1] = 0;
            priorityQueue1.add(new Node(1,0));
            while (!priorityQueue1.isEmpty()){
                Node now = priorityQueue1.remove();
                if (now.num==N) break;
                for(Node n : copyGraph.get(now.num)){
                    if (newDist[n.num] > newDist[now.num] + n.cost){
                        newDist[n.num] = newDist[now.num] + n.cost;
                        priorityQueue1.add(new Node(n.num,newDist[now.num] + n.cost));
                    }
                }
            }
            max = Math.max(max, newDist[N]);
        }

        if (max==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(max-dist[N]);
        }
    }

    static class Node{
        int num, cost;
        Node(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }

    static class Edge{
        int from, to;
        Edge(int from, int to){
            this.from = from;
            this.to =to;
        }
    }
}
