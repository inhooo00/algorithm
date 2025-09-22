package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B11725_트리의부모찾기 {
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        parents = new int[N + 1];
        parents[1] = 1;
        visited = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] arr = br.readLine().split(" ");
            graph.get(Integer.parseInt(arr[0])).add(Integer.parseInt(arr[1]));
            graph.get(Integer.parseInt(arr[1])).add(Integer.parseInt(arr[0]));
        }

        dfs(1);
        //System.out.println(graph);
        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int g : graph.get(i)) {
            if (parents[g] == 0) {
                parents[g] = i;
                dfs(g);
            }
        }
    }
}
