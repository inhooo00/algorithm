package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1937_욕심쟁이판다 {
    static int N;
    static int[][] field;
    static int[][] dp;
    static int MAX = Integer.MIN_VALUE;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i],-1);
        }
        for (int i = 0; i < N; i++) {
          String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAX = Math.max(dfs(i,j), MAX);
            }
        }
        System.out.println(MAX);
    }

    private static int dfs(int x, int y) {
        if (dp[x][y]!=-1) return dp[x][y];
        dp[x][y] = 1;
        // 비교했을 때 더 많으면 dfS로 깊어지다가
        // 갈 곳이 없을 때는 return
        boolean count = false;
        for(int[] row : rows){
            int nx = x+row[0];
            int ny = y+row[1];
            if (nx <0 || ny <0 || nx >=N || ny>=N) continue;
            if (field[x][y] < field[nx][ny]) {
                count = true;
                //System.out.println("도착");
                dp[x][y] = Math.max(dfs(nx,ny)+1, dp[x][y]);
            }
        }
        if (!count) return 1;
        return dp[x][y];
    }
}
