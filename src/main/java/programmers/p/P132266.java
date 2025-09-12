package programmers.p;

import java.util.*;

class P132266 {
    static List<List<Integer>> graph = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,-1);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(destination);
        dist[destination] = 0;

        while(!deque.isEmpty()){
            int now = deque.remove();
            for(int next : graph.get(now)){
                if(dist[next]==-1){
                    dist[next] = dist[now]+1;
                    deque.add(next);
                }
            }
        }

        for(int i=0;i<sources.length;i++){
            answer[i] = dist[sources[i]];
        }
        return answer;
    }
    class Node{
        int road;
        int count;

        Node(int road,int count){
            this.road = road;
            this.count = count;
        }
    }
}