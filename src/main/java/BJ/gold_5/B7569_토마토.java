package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

// 전형저긴 6방향 bfs
public class B7569_토마토 {
    static int M,N,H;
    static int[][][] field; // H,N,M 순으로
    static int[][] rows = {
            {1,0,0},
            {-1,0,0},
            {0,1,0},
            {0,-1,0},
            {0,0,1},
            {0,0,-1}
    };
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        field = new int[H][N][M];
        ArrayDeque<Node> deque = new ArrayDeque<>();
        // 필드 작업
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] input2 = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    field[i][j][k] = Integer.parseInt(input2[k]);
                    if (field[i][j][k]==1) {
                        deque.add(new Node(i,j,k,0));
                    }
                }
            }
        }

        while(!deque.isEmpty()){
            Node now = deque.remove();
            for(int[] row : rows){
                int newH = now.h + row[0];
                int newX = now.x + row[1];
                int newY = now.y + row[2];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M || newH < 0 || newH >= H) continue;

                if (field[newH][newX][newY]==0){
                    field[newH][newX][newY]=1;
                    deque.add(new Node(newH, newX, newY, now.depth+1));
                    result = Math.max(result, now.depth+1);
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (field[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(result);
    }

    static class Node{
        int x,y,h,depth;
        Node(int h, int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.h = h;
            this.depth = depth;
        }
    }
}
