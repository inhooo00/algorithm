package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class B14502_연구소 {
    static int N, M;
    static int[][] field;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static int Max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ar = br.readLine().split(" ");
        N = Integer.parseInt(ar[0]);
        M = Integer.parseInt(ar[1]);
        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(arr[j]);
            }
        }
        // 3단으로 bfs해서 최대값 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 0) {
                    field[i][j] = 1;
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            if (field[k][l] == 0) {
                                field[k][l] = 1;
                                for (int m = 0; m < N; m++) {
                                    for (int n = 0; n < M; n++) {
                                        if (field[m][n] == 0) {
                                            field[m][n] = 1;

                                            int[][] copy = deepCopy(field);
                                            Max = Math.max(bfs(copy), Max);

                                            field[m][n] = 0;
                                        }
                                    }
                                }
                                field[k][l] = 0;
                            }
                        }
                    }
                    field[i][j] = 0;
                }
            }
        }
        System.out.println(Max);
    }

    private static int[][] deepCopy(int[][] src) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = src[i].clone();
        }
        return copy;
    }

    private static int bfs(int[][] copy) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy[i][j]==2) list.add(new int[]{i,j});
            }
        }
        Deque<int[]> deque = new ArrayDeque<>(list);

        while (!deque.isEmpty()){
            Deque<int[]> nowDeque = new ArrayDeque<>(deque);
            for(int[] next : nowDeque){
                deque.remove();
                for(int[] row : rows){
                    if (next[0]+row[0] <0 || next[1]+row[1] <0 || next[0]+row[0] >=N || next[1]+row[1] >=M) continue;
                    if (copy[next[0]+row[0]][next[1]+row[1]]==0){
                        copy[next[0]+row[0]][next[1]+row[1]] = 2;
                        deque.add(new int[]{next[0] + row[0], next[1] + row[1]});
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] ==0) answer++;
            }

        }
        return answer;
    }
}
