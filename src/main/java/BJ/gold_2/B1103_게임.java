package BJ.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1103_게임 {
    static int N, M;
    static int[][] field;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] rows = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static boolean what = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        N = Integer.parseInt(a[0]);
        M = Integer.parseInt(a[1]);
        field = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (arr[j].equals("H")) {
                    field[i][j] = 0;
                    continue;
                }
                field[i][j] = Integer.parseInt(arr[j]);
                dp[i][j] = -1;
            }
        }

        int answer = dfs(0, 0);
        if (what) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int dfs(int x, int y) {
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        visited[x][y] = true;

        dp[x][y] = 1;
        boolean judge = false;
        for (int[] row : rows) {
            int nx = x + row[0] * field[x][y];
            int ny = y + row[1] * field[x][y];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (visited[nx][ny]) {
                what = true;
                return 0;
            }

            judge = true;
            dp[x][y] = Math.max(dp[x][y], 1 + dfs(nx, ny));

        }
        visited[x][y] = false;
        if (!judge) {
            return 1;
        }
        return dp[x][y];
    }
}
