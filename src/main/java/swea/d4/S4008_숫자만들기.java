package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4008_숫자만들기 {
    static int N, min, max;
    static int[] calList;
    static int[] numList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());

            calList = new int[4];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                calList[j] = Integer.parseInt(input[j]);
            }

            numList = new int[N];
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                numList[j] = Integer.parseInt(input2[j]);
            }


            dfs(1, numList[0]);

            System.out.println("#" + i + " " + (max - min));
        }
    }

    private static void dfs(int depth, int currentResult) {
        if (depth == N) {
            max = Math.max(max, currentResult);
            min = Math.min(min, currentResult);
            return;
        }

        // 4종류의 연산 시도
        for (int i = 0; i < 4; i++) {
            if (calList[i] > 0) {
                calList[i]--;

                int nextResult = currentResult;
                if (i == 0) nextResult += numList[depth];
                else if (i == 1) nextResult -= numList[depth];
                else if (i == 2) nextResult *= numList[depth];
                else if (i == 3) nextResult /= numList[depth];

                dfs(depth + 1, nextResult);

                calList[i]++;
            }
        }
    }
}