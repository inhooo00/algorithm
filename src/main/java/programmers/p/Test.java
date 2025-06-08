package programmers.p;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test {
    static int N; static ArrayList<Integer>[] children;
    public static void main(String[] args) {
        N = 7;
        children = new ArrayList[N + 1];
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 7}};
        for (int i = 0; i < N + 1; i++) {
            children[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            children[a].add(b);
        }
        System.out.println(BFS(1, 7));
    }

    static int BFS(int start, int goal) {
        var visited = new boolean[N + 1];
        Deque queue = new ArrayDeque<int[]>();
        queue.add(new int[]{start, 0});
        while (queue.size() > 0) {
            int[] u = (int[]) queue.remove();
            int node = u[0], distance = u[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            if (node == goal) {
                return distance;
            }
            for (int neighbor : children[node]) {
                queue.add(new int[]{neighbor, distance + 1});
            }
        }
        return -1;
    }
}
