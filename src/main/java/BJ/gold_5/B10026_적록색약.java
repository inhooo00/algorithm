package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10026_적록색약 {
    // 빨-초를(B,G) 똑같이 보는 사람과
    // 색약이 아닌 사람
    // 아닌 사람과 맞는 사람으로
    static String[][] field;
    static boolean[][] visited;
    static int[][] rows= {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    } ;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        field = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                field[i][j] = arr[j];
            }
        }
        visited = new boolean[N][N];
        //System.out.println(Arrays.deepToString(field));
        // 정상인용
        int countOne = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    countOne++;
                    dfs(i,j);
                }
            }

        }
        System.out.print(countOne +" ");
        // 배열 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }

        int countTwo = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]){
                    countTwo++;
                    dfs2(i,j);
                }
            }
        }
        System.out.println(countTwo);

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int[] row : rows){
            if (x+row[0]>=0 && y+row[1]>=0 && x+row[0]<N && y+row[1]<N){
                if (!visited[x+row[0]][y+row[1]] && field[x][y].equals(field[x+row[0]][y+row[1]])){
                    dfs(x+row[0],y+row[1]);
                }
            }
        }
    }
    //field[x][y].equals("B")&&
    // R G 하나 B
    private static void dfs2(int x, int y) {
        visited[x][y] = true;
        for(int[] row : rows){
            if (x+row[0]>=0 && y+row[1]>=0 && x+row[0]<N && y+row[1]<N){
                // B 처리
                if (!visited[x+row[0]][y+row[1]]&& field[x][y].equals("B")){
                    if(field[x][y].equals(field[x+row[0]][y+row[1]])) {
                        dfs2(x+row[0],y+row[1]);
                    }
                    // R G 동일하게 처리
                }else if (!visited[x+row[0]][y+row[1]]&& (field[x][y].equals("R") || field[x][y].equals("G"))){
                    if (field[x+row[0]][y+row[1]].equals("R")||field[x+row[0]][y+row[1]].equals("G")){
                        dfs2(x+row[0],y+row[1]);
                    }
                }
            }
        }
    }
}
