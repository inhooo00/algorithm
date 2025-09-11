package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1012_유기농배추 {
    static int[][] field;
    static boolean[][] visited;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0;i<testCase;i++){
            answer = 0;
            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            field = new int[arr[0]][arr[1]];
            visited = new boolean[arr[0]][arr[1]];
            for (int j = 0; j < arr[2]; j++) {
                int[] arr2 = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                field[arr2[0]][arr2[1]] = 1;
            }
            // dfs로 필요한 개수 탐색
            for (int j = 0; j < arr[0]; j++) {
                for (int k = 0; k < arr[1]; k++) {
                    if(!visited[j][k]&&field[j][k]==1){
                        answer++;
                        dfs(j,k, arr[0],arr[1]);
                    }
                }
            }
            System.out.println(answer);


            // 초기화
            for (int j = 0; j < arr[0]; j++) {
                Arrays.fill(field[j], 0);
            }
            for (int j = 0; j < arr[0]; j++) {
                Arrays.fill(visited[j], false);
            }
        }
    }

    private static void dfs(int x, int y, int m, int n) {
        visited[x][y]= true;
        for(int[] row : rows){
            if(x+row[0] >=0 && y+row[1] >=0 && x+row[0] <m && y+row[1]<n){
                if (!visited[x+row[0]][y+row[1]]&& field[x][y] == field[x+row[0]][y+row[1]]) dfs(x+row[0],y+row[1],m,n);
            }
        }
    }
}
