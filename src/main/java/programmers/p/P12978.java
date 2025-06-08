package programmers.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P12978 {

    public static void main(String[] args) {
        int N = 5;
        int[][] road = {
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 1},
                {2, 4, 2},
                {3, 4, 1},
                {4, 5, 3}
        };
        int K = 3;

        Solution solution = new Solution();
        int result = solution.solution(N, road, K);
        System.out.println("Result: " + result);
    }

    static class Solution {

        public int solution(int N, int[][] road, int K) {
            ArrayList<int[]>[] edges = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int[] edge : road) {
                int a = edge[0];
                int b = edge[1];
                int cost = edge[2];
                edges[a].add(new int[]{b, cost});
                edges[b].add(new int[]{a, cost});
            }

            // distances 초기값을 -1에서 Integer.MAX_VALUE로 변경
            int[] distances = new int[N + 1];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[1] = 0; // 시작 노드 거리 = 0

            //  visited 제거
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            queue.add(new int[]{1, 0});

            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int node = now[0];
                int dist = now[1];

                //  이 조건이 핵심: 현재 거리보다 더 긴 경로는 무시
                if (dist > distances[node]) continue;

                for (int[] edge : edges[node]) {
                    int neighbor = edge[0];
                    int cost = edge[1];
                    int newDist = dist + cost;

                    //  더 짧은 경로일 때만 갱신
                    if (newDist < distances[neighbor]) {
                        distances[neighbor] = newDist;
                        queue.add(new int[]{neighbor, newDist});
                    }
                }
            }
            int count = 0;
            for (int distance : distances) {
                if (distance <= K && distance != -1) {
                    count++;
                }
            }
            return count;
        }
    }
}
