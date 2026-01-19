package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 중복이 가능하고 -> 플로이드
// 모든 경로를 다 가야함 -> 백트래킹
public class B17182_우주탐사선 {
    static int N, K;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        visited = new boolean[N];
        dist = new int[N][N]; // 거리 저장

        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(input2[j]);
            }
        }
        // 모든 위치에서 최단경로 찾기 -> 목적지에 우회해서 가도 될 때 플로이드 워셜 사용.
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                for (int k = 0; k < N; k++)
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);

        visited[K] = true;
        dfs(1, 0, K);
        System.out.println(MIN);
    }
    private static void bfs(){

    }

    private static void dfs(int count, int total, int now) {
        if (total >= MIN) return;

        if (count == N) {
            MIN = Math.min(MIN, total);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문 안 한 곳만 간다
                visited[i] = true;
                dfs(count + 1, total + dist[now][i], i);
                visited[i] = false;
            }
        }
    }
}