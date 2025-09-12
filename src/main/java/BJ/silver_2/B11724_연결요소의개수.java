package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B11724_연결요소의개수 {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        graph = new ArrayList<>();
        for (int i = 0; i <= arr[0]; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[arr[0] + 1];
        int answer = 0;
        for (int i = 0; i < arr[1]; i++) {
            int[] arr1 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(arr1[0]).add(arr1[1]);
            graph.get(arr1[1]).add(arr1[0]);
        }

        for (int i = 1; i < graph.size(); i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }

        }
        System.out.println(answer);
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            if (!visited[graph.get(i).get(j)]) {
                dfs(graph.get(i).get(j));
            }

        }
    }
}
