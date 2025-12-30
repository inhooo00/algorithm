package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 부메랑 중심 *2 + 나머지 두 값.
// 강도가 가장 강하도록 구현

// 시작부터 백트래킹.
// 2각이 가능할 때 visited 처리한 후 계속해서 진행.
public class B18430_무기공학 {
    static int N, M;
    static int[][] field;
    static boolean[][] visit;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        field = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(input2[j]);
            }
        }


        dfs(0,0,0);
        System.out.println(answer);
    }

    // 시작 좌표부터 ㄱ자 만들어진 거 확인 후 백트래킹
    // 좌표 기준으로 ㄱ자 모양이 만들어지는 걸 확인하려면
    private static void dfs(int x, int y, int total) {
        if (x == N){
            answer = Math.max(answer,total);
            return;
        }

        int nextX = x;
        int nextY = y+1;
        if (nextY == M){
            nextX = x+1;
            nextY = 0;
        }

        dfs(nextX, nextY, total);

        if (!visit[x][y]) {
            // 4가지 모양 시도
            // 좌하
            if (y - 1 >= 0 && x + 1 < N && !visit[x][y - 1] && !visit[x + 1][y]) {
                visit[x][y] = true;
                visit[x][y - 1] = true;
                visit[x + 1][y] = true;
                int tempSum = (field[x][y] * 2) + field[x][y - 1] + field[x + 1][y];
                dfs(nextX, nextY, total + tempSum);
                visit[x][y] = false;
                visit[x][y - 1] = false;
                visit[x + 1][y] = false;
            }

            // 좌상
            if (y - 1 >= 0 && x - 1 >= 0 && !visit[x][y - 1] && !visit[x - 1][y]) {
                visit[x][y] = true;
                visit[x][y - 1] = true;
                visit[x - 1][y] = true;
                int tempSum = (field[x][y] * 2) + field[x][y - 1] + field[x - 1][y];
                dfs(nextX, nextY, total + tempSum);
                visit[x][y] = false;
                visit[x][y - 1] = false;
                visit[x - 1][y] = false;
            }

            // 우상
            if (y + 1 < M && x - 1 >= 0 && !visit[x][y + 1] && !visit[x - 1][y]) {
                visit[x][y] = true;
                visit[x][y + 1] = true;
                visit[x - 1][y] = true;
                int tempSum = (field[x][y] * 2) + field[x][y + 1] + field[x - 1][y];
                dfs(nextX, nextY, total + tempSum);
                visit[x][y] = false;
                visit[x][y + 1] = false;
                visit[x - 1][y] = false;
            }

            // 우하
            if (y + 1 < M && x + 1 < N && !visit[x][y + 1] && !visit[x + 1][y]) {
                visit[x][y] = true;
                visit[x][y + 1] = true;
                visit[x + 1][y] = true;
                int tempSum = (field[x][y] * 2) + field[x][y + 1] + field[x + 1][y];
                dfs(nextX, nextY, total + tempSum);
                visit[x][y] = false;
                visit[x][y + 1] = false;
                visit[x + 1][y] = false;
            }
        }
    }
}
