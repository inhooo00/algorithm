package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 약 하나를 꺼내면 그 약은 반으로 쪼개서 넣음. = W
// 반 조각을 꺼내면 그냥 먹음 = H
// 서로 다른 문자열의 개수를 구하라.

// 점점 누적되는 확률을 구해야할 듯
public class B4811_알약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            long[][] dp = new long[31][31]; // 온전, 반쪽

            for (int i = 0; i <= 30; i++) { // 온전한 약이 없을 때는 1개만 존재. 즉 30번 먹었는데 전부 반쪽
                dp[0][i] = 1; // 약을 먹었는데 그 약통에 온전한 약이 없는 상황은 항상 1개. H, HH, HHH...
            }
            for (int i = 1; i < 31; i++) {
                for (int j = 0; j < 30; j++) {
                    dp[i][j] += dp[i-1][j+1];
                    if (j>0){
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                int N = Integer.parseInt(br.readLine());
                if (N == 0) break;

                // 맨 처음 30개 들어있을 때가 답.
                sb.append(dp[N][0]).append('\n');
            }
            System.out.println(sb);
        }
    }

// W
// WH -> H뽑으면 그 다음 확률은 없어짐. 하나니까 ㅇㅇ 그렇다는 건 이 때부터 관리가 되어야한다는 건데