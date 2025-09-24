package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2186_문자판 {
    // 상하좌우 끝까지 이동 가능..
    // 시작은 아무 곳에서나 가능.
    // target을 만들 수 있는 개수를 구해야함. 타겟 도착하면 1씩 return해서 반환하는 dp 로직 설계해야할 듯.
    static int[][][] dp;
    static int N,M,K;
    static char[][] field;
    static String target;
    static int answer = 0;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        field = new char[N][M];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                field[i][j] = arr[j].charAt(0);
            }
        }
        target = br.readLine();
        dp = new int[N][M][target.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < target.length(); d++) {
                    dp[i][j][d] = -1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == target.charAt(0)) {
                    answer += dfs(i, j, 1);
                }
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int x, int y, int depth) {
        if (depth==target.length()) return 1;
        if (dp[x][y][depth]!=-1) return dp[x][y][depth];
        dp[x][y][depth] = 0;
        for (int i=1;i<=K;i++){ // 리미트 개수
            for (int[] row : rows){
                int nx = x+row[0]*i;
                int ny = y+row[1]*i;
                if (nx <0 || ny <0 || nx >= N || ny >=M) continue;
                if (target.charAt(depth)== field[nx][ny]){
//                    System.out.println("시작" +nx+" " +ny);
                    dp[x][y][depth] +=dfs(nx,ny,depth+1);
                }
            }
        }

        return dp[x][y][depth];
    }
}
