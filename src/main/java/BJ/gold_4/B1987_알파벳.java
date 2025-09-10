package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B1987_알파벳 {
    // DFS 백트레킹
    // 0,0으로 시작하며 map 에 쌓아감.
    // 4방향으로 움직이면서. 겹치는지 확인. 겹치면 거기까지의 합으로 초기화.
    static int N, M;
    static int result = Integer.MIN_VALUE;
    static int[][] rows = {
            {1, 0}, //아래
            {-1, 0}, // 위
            {0, 1}, // 오른쪽
            {0, -1} //왼쪽
    };
    static String[][] arr; // 알파벳
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        N = Integer.parseInt(arr1[0]);
        M = Integer.parseInt(arr1[1]);
        arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = arr2[j];
            }
        }
        map.put(arr[0][0], 1);
        dfs(0, 0, 1);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int depth) {
        result = Math.max(result, depth);
        for (int[] row : rows) {
            int nx = x + row[0];
            int ny = y + row[1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(map.get(arr[nx][ny])==null){
                    map.put(arr[nx][ny],1);
                    dfs(nx,ny,depth+1);
                    map.remove(arr[nx][ny]);
                }
            }
        }
    }


}
