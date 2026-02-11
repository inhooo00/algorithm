package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 조합
public class S1486_장훈이의높은선반 {
    static int B, N;
    static int[] people;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            N = input[0]; // 점원 수
            B = input[1]; // 선반 높이
            min = Integer.MAX_VALUE;
            people = new int[N];
            visited = new boolean[N];
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                people[j] = Integer.parseInt(input2[j]);
            }

            dfs(0, 0);
            System.out.println("#" + i + " " + (min-B));
        }
    }

    private static void dfs(int depth, int total) {
        if (total >= B) {
            min = Math.min(min, total);
        }

        if (depth == N) {
            return;
        }
        if (!visited[depth]){
            visited[depth] = true;
            dfs(depth + 1, total + people[depth]);
            visited[depth] = false;
        }

        dfs(depth + 1, total);
    }
}

