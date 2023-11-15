package silver_3;

import java.util.*;

class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer;

    public static void dfs(int idx) {
        visited[idx] = true;
        answer++;
        for (int i = 1; i <= N; i++)
            if (visited[i] == false && graph[idx][i])
                dfs(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        int x, y;
        for (int i = 0; i < M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        dfs(1);

        System.out.println(answer - 1);
        sc.close();
    }
}
/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N];
        arr[0] = true;
        int count = 0;

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if (arr[num1 - 1]) arr[num2 - 1] = true;
            if (arr[num2 - 1]) arr[num1 - 1] = true;

        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i])
                count++;
        }

        System.out.println(count - 1);
    }
}
*/