package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예제 입력 1
//3 4
//3 7 5
//예제 출력 1
//4
public class B18429_근손실 {
    static int N, K, answer;
    static boolean B[];
    static String kits[];

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]); //갯수
        K = Integer.parseInt(arr[1]); // 근손실량
        kits = br.readLine().split(" ");
        B = new boolean[N]; //충족 판별
        dfs(500, 0);
        System.out.println(answer);
    }

    static void dfs(int w, int day) {
        if (day == N) {
            answer++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (B[i]) continue;
            B[i] = true;
            if (w + Integer.parseInt(kits[i]) - K >= 500) {
                dfs(w + Integer.parseInt(kits[i]) - K, day + 1);
            }
            B[i] = false;
        }
    }
}
