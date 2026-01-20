package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 2변 이상 접속한 것마다 없애기
// 내부 공간은 어떻게 판단하지..
public class B2638_치즈 {
    static int N,M;
    static int[][] field;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        field = new int[N][M];
        Deque<Node> deque = new ArrayDeque<>(); // bfs 할 거
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(input2[j]);
                if (field[i][j]==1) deque.add(new Node(i,j));
            }
        }
        int[][] copyField = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyField[i][j] = field[i][j];
            }
        }
        int answer = 0;
        while (true){ // 전부 다 녹을 때까지 반복하기
            // 바깥공기 판별 로직
            boolean[][] isOutside = new boolean[N][M];
            Deque<Node> airQ = new ArrayDeque<>();
            airQ.add(new Node(0, 0));
            isOutside[0][0] = true;

            while(!airQ.isEmpty()) {
                Node air = airQ.remove();
                for(int[] row : rows) {
                    int nx = air.x + row[0];
                    int ny = air.y + row[1];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    // 공기(0)이고 아직 방문 안 했으면 -> 바깥 공기임
                    if (field[nx][ny] == 0 && !isOutside[nx][ny]) {
                        isOutside[nx][ny] = true;
                        airQ.add(new Node(nx, ny));
                    }
                }
            }


            boolean check = false;
            while(!deque.isEmpty()){ // 한싸이클 돌리기
                check = true;
                Node now = deque.remove();
                int num = 0;
                for(int[] row : rows){
                    int newX = now.x + row[0];
                    int newY = now.y + row[1];
                    if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
                    if (isOutside[newX][newY]) {
                        num++;
                    }
                }
                if (num >=2) copyField[now.x][now.y] = 0;
            }
            if (!check) break;
            else {
                answer++;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    field[i][j] = copyField[i][j];
                    if (field[i][j] ==1) deque.add(new Node(i,j));
                }
            }
        }

        System.out.println(answer);
    }
    static class Node {
        int x,y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
