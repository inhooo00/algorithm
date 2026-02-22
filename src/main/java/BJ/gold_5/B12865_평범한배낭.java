package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12865_평범한배낭 {
    static int N, K;
    static int[][] item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 개수
        K = Integer.parseInt(input[1]); // 최대크기
        item = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            item[i][0] = Integer.parseInt(input2[0]);
            item[i][1] = Integer.parseInt(input2[1]);
        }
        // 배낭문제.
        // 물건의 최대 = 가치
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) { // 물건을 하나씩 확인
            for (int j = 1; j <= K; j++) { // 최대까지
                if (j - item[i-1][0] < 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item[i-1][0]] + item[i-1][1]);
                }

            }
        }
        System.out.println(dp[N][K]);
    }
}
