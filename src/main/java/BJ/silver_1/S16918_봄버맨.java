package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class S16918_봄버맨 {
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    // 맨 처음 폭탄 설치 0초
    // 가만히 있음 1초
    // 빈칸 모두 폭탄 설치 2초
    // 맨 처음 폭탄 붐 3초
    // 빈 칸 모두 폭탄 설치 4초
    // 폭탄 붐 5초
    // 빈 칸 모두 폭탄 설치 6초..
    static String[][] field;
    static int R,C,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input =br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);
        field = new String[R][C];
        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                field[i][j] = input2[j];
                if (field[i][j].equals("O")) deque.add(new Node(i,j,2));
            }
        }

        for (int i = 2; i <= N; i++) { // N초

            int qSize = deque.size();
            for (int j = 0; j < qSize; j++) {
                Node n = deque.remove();
                if (field[n.x][n.y].equals("O")) {
                    n.time--;
                    deque.add(n);
                }
            }

            // 넣기
            if (i%2==0){
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (field[j][k].equals(".")){
                            field[j][k] = "O";
                            deque.add(new Node(j,k,3));
                        }
                    }
                }
            }

            // 0초 터트리기
            int size = deque.size();
            List<Node> boom = new ArrayList<>();
            for (int j = 0; j<size;j++){
                Node now = deque.remove();
                if (now.time==0){
                    boom.add(now);
                }else deque.add(now);
            }

            for (Node N : boom){
                field[N.x][N.y] = ".";
                for(int[] row :rows){
                    int newX = N.x + row[0];
                    int newY = N.y + row[1];
                    if (newX < 0 || newX >= R || newY < 0 || newY >= C) continue;
                    field[newX][newY] = ".";
                }
            }

        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    static class Node{
        int x,y,time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
