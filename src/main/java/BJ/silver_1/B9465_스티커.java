package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //테스트 개수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 스티커 개수
            int[][] arr = new int[3][n+1];
            for (int j = 1; j <= 2; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(input[k-1]);
                }
            }
            int[][] dp = new int[3][n+1]; // 행과 열

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            for (int j = 2; j <= n; j++) {
                dp[1][j] = Math.max(dp[1][j-1],dp[2][j-1]+arr[1][j]);
                dp[2][j] = Math.max(dp[2][j-1],dp[1][j-1]+arr[2][j]);
            }

            System.out.println(Math.max(dp[1][n], dp[2][n]));
        }
    }
}
