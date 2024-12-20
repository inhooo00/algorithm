package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2422_한윤정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");

        boolean[][] B = new boolean[Integer.parseInt(S[0]) + 1][Integer.parseInt(S[0]) + 1];
        for (int i = 0; i < Integer.parseInt(S[1]); i++) { //  받은 값 true로 저장
            String[] input = br.readLine().split(" ");
            B[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            B[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }
        int answer = 0;

        for (int i = 1; i <= Integer.parseInt(S[0]); i++) {
            for (int j = i + 1; j <= Integer.parseInt(S[0]); j++) {
                if (B[i][j]) continue;
                for (int k = j + 1; k <= Integer.parseInt(S[0]); k++) {
                    if (!B[j][k] && !B[k][i]) {
                        answer++;
                    }

                }
            }
        }
        System.out.println(answer);

    }
}
