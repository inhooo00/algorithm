package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//
public class B2667_단지번호붙이기 {
    static int[][] danji;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    static int[][] rows = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    static int num;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        danji = new int[num][num];
        visited = new boolean[num][num];
        for (int i = 0; i < num; i++) {
            int[] arr = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < num; j++) {
                danji[i][j] = arr[j];
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j] && danji[i][j] == 1) {
                    int count = dfs(i, j);
                    queue.add(count);
                }

            }

        }

        System.out.println(queue.size());
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    private static int dfs(int i, int j) {
        visited[i][j] = true;
        int count = 1;
        for (int[] row : rows) {
            if (i + row[0] >= 0 && j + row[1] >= 0 && i + row[0] < num && j + row[1] < num) {
                if (danji[i + row[0]][j + row[1]] == 1 && !visited[i + row[0]][j + row[1]]) {
                    count += dfs(i + row[0], j + row[1]);
                }
            }
        }
        return count;
    }
}
