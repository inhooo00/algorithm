package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10974_모든순열 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        visited = new boolean[N+1];
        dfs(0,arr);

        System.out.println(sb);
    }

    static private void dfs(int depth, int[] arr){
        if (depth==N){
            for (int a : arr){
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i+1]){
                arr[depth] = i+1;
                visited[i+1]=  true;
                dfs(depth+1,arr);
                visited[i+1] = false;
            }
        }
    }
}
