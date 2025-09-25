package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// + - 만 써서
// 마지막에는 =로 처리해서 수식 완성하기
// 총 가능한 개수를 구하자. 1차원 dp인가
// 아니지 +혹은 -로 올 수 있으니 총 경우가 2개잖아. 2차원 dp
public class B5557_1학년 {
    static int N;
    static int[] field;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        field = new int[N];
        dp = new long[N][21];
        for (int i = 0; i < N; i++) {
            field[i] = Integer.parseInt(input[i]);
            Arrays.fill(dp[i],-1);
        }

        System.out.println(dfs(0, field[0]));
    }

    // 시작 기준으로 총 개수를 반환하도록.
    // 그러려면 도착했을 때 (1)가 뒤로 계속해서 return되는 구조로 설계해야함.

    private static long dfs(int y, int now) {
        if (y==N-2 && now == field[N-1]) return 1;
        if (y==N-2) return 0;
        if (dp[y][now] != -1) return dp[y][now];
        dp[y][now] = 0;

        //System.out.println("dfs시작"+y);
        for (int i = 0; i < 2; i++) {
            if (i==0 && now+ field[y+1] > 20) continue;
            if (i==0) dp[y][now] += dfs(y+1,now+ field[y+1]);
            if (i==1 && now -field[y+1] <0) continue;
            if(i==1) dp[y][now] += dfs(y+1,now-field[y+1]);
        }
        return dp[y][now];
    }
}
