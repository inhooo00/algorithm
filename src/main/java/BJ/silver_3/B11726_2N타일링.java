package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726_2N타일링 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[1] =1;
        if (N>=2){
            dp[2] = 2;
        }
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
}
