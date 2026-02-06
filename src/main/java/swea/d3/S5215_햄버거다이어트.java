package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5215_햄버거다이어트 {
    static int N,L;
    static int[][] arr;
    static boolean[] visited;
    static int max;
    // weight , value
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int i=1;i<=TC;i++){
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            L = Integer.parseInt(input[1]);
            arr = new int[N][2];
            visited = new boolean[N];
            max = 0;
            for (int j = 0; j < N; j++) {
                String[] input2 = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(input2[0]);
                arr[j][1] = Integer.parseInt(input2[1]);
            }
            dfs(0, 0,0);
            System.out.println("#"+i +" "+max);
        }
    }

    private static void dfs(int depth, int total, int weight){
        if (depth ==N){
            //System.out.println(Arrays.toString(visited));
            if (weight<=L) max = Math.max(max, total);
            return;
        }
            if (!visited[depth]){
                visited[depth] = true;
                dfs(depth+1,total+arr[depth][0], weight+arr[depth][1]);
                visited[depth] = false;
            }
            dfs(depth+1, total, weight);

    }
}
