package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class B7576_토마토 {
    static int[][] field;
    static int N, M;
    static boolean[][] visited;
    static int[][] rows = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int count = -1;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        field = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] arr1 = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(arr1[j]);
                if (field[i][j] == 1) list.add(new int[]{i,j});
            }
        }
        Deque<int[]> deque = new ArrayDeque<>(list);
        while (!deque.isEmpty()){
            Deque<int[]> nowDeque = new ArrayDeque<>(deque);
            for (int[] array : nowDeque){
                deque.remove();
                for(int[] row : rows){
                    if(array[0]+row[0] <0 || array[1]+row[1] < 0 || array[0]+row[0] >= M || array[1]+row[1] >= N) continue;
                    if (field[array[0]+row[0]][array[1]+row[1]]==0){
                        field[array[0]+row[0]][array[1]+row[1]] = 1;
                        deque.add(new int[]{array[0]+row[0],array[1]+row[1]});
                    }
                }
            }
            count++;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (field[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }

}
