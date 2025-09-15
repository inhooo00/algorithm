package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class B1260_DFS와BFS {
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = input[0];
        M = input[1];
        int Q = input[2];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort((a, b) -> a - b);
        }

        dfs(Q);

        Arrays.fill(visited,false);

        bfs(Q);
        for(int num1 : dfsResult){
            System.out.print(num1 +" ");
        }
        System.out.println();
        for (int num2 : bfsResult){
            System.out.print(num2 +" ");
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        dfsResult.add(start);
            for (int num : graph.get(start)) {
                if (!visited[num]) {
                    dfs(num);
                }
            }
    }

    private static void bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        bfsResult.add(start);
        visited[start] = true;

        while (!deque.isEmpty()){
            int now = deque.remove();

            for (int num : graph.get(now)){
                if(!visited[num]) {
                    visited[num] = true;
                    bfsResult.add(num);
                    deque.add(num);
                }
            }
        }
    }
}
