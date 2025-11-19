package BJ.gold_4;

// 받을 수 있는 자두 개수 구하기.
// 최대 W만 움직이고 싶음.
// 시작은 1번 나무고, 1과2나무중 랜덤하게 떨어짐.

// 최소 이동이니까 최대
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2240_자두나무 {
    static int T,W;
    static int[][][] dp;
    static int[] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        T = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        dp = new int[T+1][W+1][3]; // 시간,이동횟수, 현재위치
        field = new int[T+1];

        for (int i = 1; i <= T; i++) {
            int num = Integer.parseInt(br.readLine());
            field[i] = num;
        }

        if (field[1] == 1){ // 시작이 1일 때
            dp[1][0][1] = 1;
            dp[1][1][2] = 0;
        }else { // 시작이 2일 때
            dp[1][0][1] = 0;
            dp[1][1][2] = 1;
        }

        for (int i = 2; i < field.length; i++) {
            int now = field[i];
            for (int j = 0; j <= W ; j++) {
                int catch1 = (now ==1) ? 1: 0; // 1번 나무에서 떨어졌을 때.
                dp[i][j][1] =  dp[i-1][j][1] + catch1; // 똑같이 1번 나무 유지할 때.
                if (j>=1){
                    int move_path = dp[i - 1][j - 1][2] + catch1;
                    dp[i][j][1] = Math.max(dp[i][j][1], move_path);
                }

                if (j >= 1) { // 2번 나무에 떨어졌을 때
                    int catch2 = (now == 2) ? 1 : 0;
                    dp[i][j][2] = dp[i - 1][j][2] + catch2; // 똑같이 2번 나무 유지할 때
                    int move_path = dp[i - 1][j - 1][1] + catch2;
                    dp[i][j][2] = Math.max(dp[i][j][2], move_path);
                }
            }
        }
        int max = 0;
        for (int i = 0; i <= W; i++) {
            max = Math.max(max, dp[T][i][1]);
            max = Math.max(max, dp[T][i][2]);
        }
        System.out.println(max);
    }
}
