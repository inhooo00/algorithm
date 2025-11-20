package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class B14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Table[] field = new Table[N+1];
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            field[i] = new Table(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        int[] dp = new int[N+1];
        dp[1] = field[1].pay;

        for (int i = 1; i <= N; i++) {
            if (field[i].time+i > N){ // 지금 값의 시간이 오바되면
                dp[i] = dp[i-1];
                System.out.println(i);
                continue;
            }
            dp[field[i].time+i] = Math.max(dp[field[i].time+i], field[field[i].time+i].pay+dp[i]);
            // 지금 값의 이전값과 지금값을 비교
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }

    static class Table{
        int time,pay;
        Table(int time, int pay){
            this.time = time;
            this.pay = pay;
        }
    }
}
