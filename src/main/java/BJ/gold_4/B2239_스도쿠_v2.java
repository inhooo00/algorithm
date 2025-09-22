package BJ.gold_4;

// 9*9 스도쿠 문제..
// 가로 세로 확인. 대각선 확인.... 각 필드 확인..

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239_스도쿠_v2 {
    static int[][] field = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }

        solve();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (field[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(i, j, k)) {
                            field[i][j] = k;
                            if (solve()) {
                                return true;
                            }
                            field[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int i, int j, int k) {
        for (int l = 0; l < 9; l++) {
            if (field[i][l] == k || field[l][j] == k){
                return false;
            }
        }

        int x = (i/3)*3;
        int y = (j/3)*3;

        for (int l = x; l < x+3; l++) {
            for (int m = y; m < y+3; m++) {
                if (field[l][m]==k){
                    return false;
                }
            }
        }
        return true;
    }
}
