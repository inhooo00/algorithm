package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B15652_N과M4 {
    static List<int[]> arr = new ArrayList<>();
    static int[] arr1;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = arr[0];
        M = arr[1];
        arr1 = new int[M];
        dfs(0, 1);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth==M) {
            for(int n : arr1){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int j = start; j <= N ; j++) {
            arr1[depth] = j;
            dfs(depth+1,j);
        }
    }
}
