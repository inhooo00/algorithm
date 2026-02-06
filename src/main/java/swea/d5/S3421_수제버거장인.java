package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S3421_수제버거장인 {
    static int N,M,answer;
    static boolean[] visited;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            graph = new ArrayList<>();
            answer = 0;
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }
            visited = new boolean[N+1];
            for (int j = 0; j < M; j++) {
                String[] input2 = br.readLine().split(" ");
                graph.get(Integer.parseInt(input2[0])).add(Integer.parseInt(input2[1]));
                graph.get(Integer.parseInt(input2[1])).add(Integer.parseInt(input2[0]));
            }
            //System.out.println(graph);
            dfs(1);
            System.out.println("#"+i+" "+answer);
        }
    }

    private static void dfs(int depth) {
        if (depth == N+1){
            //System.out.println(Arrays.toString(visited));
            answer++;
            return;
        }
        if (isCan(depth)){ // 넣을 수 있을 때
            visited[depth] = true;
            dfs(depth+1);
            visited[depth] = false;
        }
        dfs(depth+1);
    }

    private static boolean isCan(int depth) {
        for(int i: graph.get(depth)){
            if (visited[i]) return false;
        }
        return true;
    }
}
