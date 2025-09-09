package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15650_N과M2 {
    static int N, M;
    static int[] arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        arr1 = new int[M];
        dfs(1, 0);

    }

    private static void dfs(int at, int depth) {

        if (depth == M) {
            for (int num : arr1) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <= N; i++) {
            arr1[depth] = i;
            //System.out.println(at+"번째에서 시작 " +i);
            dfs(1 + i, depth + 1);
        }

    }
}
