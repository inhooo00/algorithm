package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2458_키순서 {
    static int N,M;
    static boolean[][] field;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        field = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            String[] input2 = br.readLine().split(" ");
            int to = Integer.parseInt(input2[0]);
            int from = Integer.parseInt(input2[1]);
            field[to-1][from-1] = true;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (field[j][i] && field[i][k]) field[j][k] = true;
                }
            }
        }
        //System.out.println(Arrays.deepToString(field));

        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                if (field[i][j] || field[j][i]) count++;
            }
            if (count==N-1) result++;
        }
        System.out.println(result);
    }
}

/**
 6 6
  1 5
  3 4
  5 4
  4 2
  4 6
  5 2
 */