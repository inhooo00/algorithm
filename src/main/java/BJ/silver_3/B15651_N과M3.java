package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15651_N과M3 {
    static int N, M;
    static int[] arr1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        arr1 = new int[M];
        dfs(1, 0);
        System.out.println(sb);

    }

    private static void dfs(int at, int depth) {

        if (depth == M) {
            for (int num : arr1) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr1[depth] = i;
            //System.out.println(at+"번째에서 시작 " +i);
            dfs(i, depth + 1);
        }

    }
}
