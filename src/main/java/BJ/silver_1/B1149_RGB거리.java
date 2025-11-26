package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][3];
        String[] input = br.readLine().split(" ");
        dp[1][0] = Integer.parseInt(input[0]);
        dp[1][1] = Integer.parseInt(input[1]);
        dp[1][2] = Integer.parseInt(input[2]);

        for (int i = 2; i <= N; i++) {
            String[] input2 = br.readLine().split(" ");
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + Integer.parseInt(input2[0]);
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + Integer.parseInt(input2[1]);
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + Integer.parseInt(input2[2]);
        }
        System.out.println(Math.min(dp[N][2],Math.min(dp[N][0],dp[N][1])));
    }
}
