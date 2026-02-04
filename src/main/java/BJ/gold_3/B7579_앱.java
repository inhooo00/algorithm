package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B7579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N][2];
        String[] input2 = br.readLine().split(" ");
        String[] input3 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(input2[i]);
            arr[i][1] = Integer.parseInt(input3[i]);
        }

        // M이상 확보하면서 매모리는 가장 적게
        int[] dp = new int[10001];
        for (int i = 0; i < N; i++) {
            int nowMemo = arr[i][0];
            int nowTime = arr[i][1];
            for (int j = 10000; j >= nowTime; j--) {
                dp[j] = Math.max(dp[j], dp[j - nowTime] + nowMemo);
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= M){
                System.out.println(i);
                break;
            }
        }
    }
}
//dp[비용] = 확보할 수 있는 최대 메모리
//배열 크기: 최대 비용 합인 10001만큼만 잡으면 됩니다. (new int[10001])
//목표: dp 배열을 다 채운 뒤, dp[i] >= M 을 만족하는 가장 작은 i(비용) 를 찾으면 됩니다.