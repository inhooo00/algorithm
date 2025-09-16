package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9663_NQueen {
    static int N;
    static int answer = 0;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];

        dfs(0);  // 0번째 행부터 시작

        System.out.println(answer);
    }

    private static void dfs(int row) {
        if(row==N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(col[i] || diag1[row+i] || diag2[row-i+N-1]) continue;

            col[i] = true;
            diag1[row+i] = true;
            diag2[row-i+N-1] = true;

            dfs(row+1);

            col[i] = false;
            diag1[row+i] = false;
            diag2[row-i+N-1] = false;
        }
    }
}
