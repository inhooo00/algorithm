package swea.mo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1일 이용권, 한달, 3달, 1년....
public class B1952_수영장 {
    static int[] plan;
    static int day, month, month3, year;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T ; i++) {
            String[] input = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            plan = new int[13];
            for (int j = 1; j <= 12; j++) {
                plan[j] = Integer.parseInt(input2[j-1]);
            }
            day = Integer.parseInt(input[0]);
            month = Integer.parseInt(input[1]);
            month3= Integer.parseInt(input[2]);
            year = Integer.parseInt(input[3]);

            dp = new int[13];
            for (int j = 1; j < plan.length; j++) {
                int dayMoney = plan[j]*day;
                int monthMoney = month;
                dp[j] = dp[j-1]+Math.min(dayMoney,monthMoney);

                if (j >= 3){
                    dp[j] = Math.min((dp[j]),dp[j-3]+month3);
                }
            }
            System.out.println("#"+i+" "+Math.min(dp[12], year));
        }
    }
}
