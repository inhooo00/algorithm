package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2468_안전영역 {
    static int[][] field;
    static boolean[][] visited;
    static int[][] rows = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int N;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }
        for (int t = 0; t <= 100; t++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && field[i][j] > t) {
                        //System.out.print("i값" +i);
                        //System.out.println(" j값" +j);
                        count++;
                        dfs(i, j, t);
                    }

                }
            }
            MAX = Math.max(count, MAX);
        }

        System.out.println(MAX);
        //System.out.println(Arrays.deepToString(field));
    }

    private static void dfs(int x, int y, int num) {
        visited[x][y] = true;
        for (int[] row : rows) {
            if (x + row[0] < 0 || y + row[1] < 0 || x + row[0] >= N || y + row[1] >= N) {
                continue;
            }
            if (!visited[x + row[0]][y + row[1]]) {
                if (field[x + row[0]][y + row[1]] > num) {
                    //System.out.println("카운트하는 필드" +field[x+row[0]][y+row[1]] + "X값" +x+row[0] +"Y값" + y+row[1]);
                    dfs(x + row[0], y + row[1], num);
                }
            }
        }
    }
}
