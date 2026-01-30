package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2096_내려가기 {
    static int[][] rows = {
            {1,0},
            {1,1},
            {1,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][3];
        int[][][] dp = new int[N][3][2]; // 0=max 1=min
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            field[i][0] = Integer.parseInt(input[0]);
            field[i][1] = Integer.parseInt(input[1]);
            field[i][2] = Integer.parseInt(input[2]);
        }
        dp[0][0][0] = field[0][0];
        dp[0][1][0] = field[0][1];
        dp[0][2][0] = field[0][2];
        dp[0][0][1] = field[0][0];
        dp[0][1][1] = field[0][1];
        dp[0][2][1] = field[0][2];

        // 지금 내
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < 3; j++) {
                for(int[] row : rows){
                    int newX = row[0] + i;
                    int newY = row[1] + j;
                    if (newX < 0 || newX >= N || newY < 0 || newY >= 3) continue;
                    dp[newX][newY][0] = Math.max(dp[newX][newY][0], dp[i][j][0]+field[newX][newY]);
                    if (dp[newX][newY][1] == 0) dp[newX][newY][1] = dp[i][j][1]+field[newX][newY];
                    else dp[newX][newY][1] = Math.min(dp[newX][newY][1], dp[i][j][1]+field[newX][newY]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            max = Math.max(max,dp[N-1][i][0]);
            min = Math.min(min,dp[N-1][i][1]);
        }
        System.out.println(max + " " + min);
    }
}
