package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4130_특이한자석 {
    static int[][] mag;
    static int[][] rt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int K = Integer.parseInt(br.readLine()); // 자석 회전 횟수
            mag = new int[4][8];
            for (int j = 0; j < 4; j++) { // 자석
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 8; k++) {
                    mag[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            rt = new int[K][2];
            for (int j = 0; j < K; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                rt[j][0] = Integer.parseInt(st.nextToken())-1;
                rt[j][1] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < K; j++) {
                int magNum = rt[j][0];
                int magDir = rt[j][1];

                // 왼쪽으로 연쇄 확인
                if (magNum - 1 >= 0) {
                    dfs(magNum - 1, -magDir, 1);
                }

                // 오른쪽으로 연쇄 확인
                if (magNum + 1 <= 3) {
                    dfs(magNum + 1, -magDir, 2);
                }

                // 현재 위치 마지막으로 확인
                if (magDir == 1) rtOne(magNum);
                else rtTwo(magNum);
            }

            int ans = 0;
            if (mag[0][0] == 1) ans += 1;
            if (mag[1][0] == 1) ans += 2;
            if (mag[2][0] == 1) ans += 4;
            if (mag[3][0] == 1) ans += 8;

            System.out.println("#" + i + " " + ans);
        }
    }

    private static void dfs(int magNum, int magRow, int to) {
        if (to == 1) {
            if (mag[magNum][2] != mag[magNum + 1][6]) { // 돌아가는 조건일 때만 dfs 진행
                if (magNum - 1 >= 0) dfs(magNum - 1, -magRow, 1);
                if (magRow == 1) rtOne(magNum);
                else rtTwo(magNum);
            }
        }
        else if (to == 2) {
            if (mag[magNum][6] != mag[magNum - 1][2]) { // 돌아가는 조건일 때만 dfs 진행
                if (magNum + 1 <= 3) dfs(magNum + 1, -magRow, 2);
                if (magRow == 1) rtOne(magNum);
                else rtTwo(magNum);
            }
        }
    }

    private static void rtOne(int num) { // 시계 방향 회전
        int lastNum = mag[num][7];
        for (int i = 7; i >= 1; i--) {
            mag[num][i] = mag[num][i - 1];
        }
        mag[num][0] = lastNum;
    }

    private static void rtTwo(int num) { // 반시계 방향 회전
        int firstNum = mag[num][0];
        for (int i = 0; i < 7; i++) {
            mag[num][i] = mag[num][i + 1];
        }
        mag[num][7] = firstNum;
    }
}