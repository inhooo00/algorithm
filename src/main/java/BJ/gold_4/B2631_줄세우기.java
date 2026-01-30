package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// N명의 아이들이 있다.
// 무작위로 오는 아이들을 순서대로 세우는 최소값을 구하자.
public class B2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] field = new int[N+1];
        for (int i = 1; i <= N; i++) {
            field[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        int max = Integer.MIN_VALUE;
        // 1~7 부터 2~7, 3~7.. 하면서 누적해서 가장 최대 값 찾기.
        for (int i = 1; i < N+1; i++) {
            dp[i]=1;
            for (int j = 1; j < i; j++) {
                if (field[i] >field[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(N-max);
    }
}
