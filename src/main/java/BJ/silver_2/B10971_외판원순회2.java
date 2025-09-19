package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10971_외판원순회2 {
    static int N;
    static int[][] field;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            dfs(0, i, i, 0); // 0번째부터 시작..
        }
        //System.out.println(Arrays.deepToString(field));
        System.out.println(min);
    }

    private static void dfs(int depth, int start, int now, int count) {
        if (depth == N && now == start) {
            //System.out.println("count 걸림 " + count);
            min = Math.min(min, count);
            return;
        }
        if (depth >N) return;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && field[now][i] != 0) {
                visited[i] = true;
                //System.out.println("지금 depth"+ depth +""+now+" 지금 count" + count);
                dfs(depth + 1, start, i, count + field[now][i]);
                visited[i] = false;
            }

        }

    }
}
