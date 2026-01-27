package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 시간과 먼저 지어야하는 번호를 제공받음.

public class B1516_게임개발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];
        int[] buildTime = new int[N + 1];
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            buildTime[i] = Integer.parseInt(input[0]);
            for (int j = 1; j < input.length; j++) {
                int pre = Integer.parseInt(input[j]);
                if (pre == -1) break;
                adj[pre].add(i); // pre 건물을 지어야 i 건물을 지을 수 있음
                indegree[i]++;   // i의 진입 차수 증가
            }
        }

        // 진입하는 차수가 0인 것을 초기값으로 설정해두기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                result[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : adj[now]) {
                result[next] = Math.max(result[next], result[now] + buildTime[next]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }
}
