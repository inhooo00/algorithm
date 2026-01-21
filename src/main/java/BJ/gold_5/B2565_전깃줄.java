package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// A로 오름차순 정렬했을 때, B도 오름차순인 경우일 때를 구하기.
// 그 때가
public class B2565_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            field[i][0] = Integer.parseInt(input[0]);
            field[i][1] = Integer.parseInt(input[1]);
        }
        int[] dp = new int[N];
        Arrays.sort(field, (a,b)-> a[0]-b[0]);
        int maxLen = 0;

        // 가장 긴 수열 찾기
        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            // i까지만 돌리기. 지나온 부분만 봄.
            for (int j = 0; j < i; j++) {
                if (field[i][1] > field[j][1]) { // 가장 긴 수열로 업데이트
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(N-maxLen);
    }
}
