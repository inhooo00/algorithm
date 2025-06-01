package programmers.p;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P49189 {

    public static void main(String[] args) {
        // Example usage
        int n = 6;
        int[][] edge = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        Solution solution = new Solution();
        int result = solution.solution(n, edge);
        System.out.println(result); // Expected output: 3
    }

    static class Solution {
        static int N;
        static ArrayList<Integer>[] neighbors;

        public int solution(int n, int[][] edge) {
            N = n;
            neighbors = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                neighbors[i] = new ArrayList<>();
            }
            for (int[] singleEdge : edge) {
                int a = singleEdge[0];
                int b = singleEdge[1];
                neighbors[a].add(b);
                neighbors[b].add(a);
            }
            int[] distances = BFS(1);

            //아래는 이제 최대값 개수 구하는 로직
            int max = 0;
            int count = 0;

            for (int value : distances) {
                if (value > max) {
                    max = value;
                    count = 1;
                } else if (value == max) {
                    count++;
                }
            }
            return count;
        }

        static int[] BFS(int start) {
            int[] distances = new int[N + 1];
            Arrays.fill(distances, -1);
            Deque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{start, 0});

            while (queue.size() > 0) {
                int[] u = queue.remove();
                int node = u[0];
                int distance = u[1];
                if (distances[node] >= 0) {
                    continue;
                }
                distances[node] = distance;
                for (int neighbor : neighbors[node]) {
                    queue.add(new int[]{neighbor, distance + 1});
                }
            }
                return distances;
            }
        }
    }
