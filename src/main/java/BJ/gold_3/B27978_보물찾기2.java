package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// 8칸 중 하나로 이동 가능.
// 왼쪽에서 오른쪽 갈 때는 연료가 안 드는데
// 오른쪽에서 왼쪽으로 갈 때는 연로가 1 듦.
// . = 바다
// # = 암초
// * = 보물
// K = 배
// 1씩 증가하는 최소값을 구하자. = 0-1 BFS
public class B27978_보물찾기2 {
    static int H,W;
    static String[][] field;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int[][] dir;
    static int[][] go = {
            {-1,1},
            {0,1},
            {1,1}
    };
    static int[][] back = {
            {-1,0},
            {1,0},
            {0,-1},
            {-1,-1},
            {1,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        dir = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(dir[i],Integer.MAX_VALUE);
        }
        field = new String[H][W];
        for (int i = 0; i < H; i++) {
            String[] input2 = br.readLine().split("");
            for (int j = 0; j < W; j++) {
                field[i][j] = input2[j];
                if (input2[j].equals("K")){
                    start[0] = i;
                    start[1] = j;
                }else if (input2[j].equals("*")){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        // 최소값 찾기 진행
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a,b)-> a.total- b.total);
        priorityQueue.add(new Node(start[0], start[1], 0));
        dir[start[0]][start[1]] = 0;
        while (!priorityQueue.isEmpty()){
            Node now = priorityQueue.remove();

            // 목적지 도달했을 때
            if (now.x==end[0] && now.y==end[1]){
                System.out.println(now.total);
                System.exit(0);
            }

            // 정방향 +0으로 이동
            for (int[] g : go){
                int nowX = now.x + g[0];
                int nowY = now.y + g[1];
                if (nowX <0 || nowY <0 || nowX >= H || nowY >= W || field[nowX][nowY].equals("#")) continue;
                if (dir[nowX][nowY] > now.total){
                    dir[nowX][nowY] = now.total;
                    priorityQueue.add(new Node(nowX, nowY, now.total));
                }
            }

            for (int[] b : back){
                int nowX = now.x + b[0];
                int nowY = now.y + b[1];
                if (nowX <0 || nowY <0 || nowX >= H || nowY >= W || field[nowX][nowY].equals("#")) continue;
                if (dir[nowX][nowY] > now.total+1){
                    dir[nowX][nowY] = now.total+1;
                    priorityQueue.add(new Node(nowX, nowY, now.total+1));
                }
            }
        }

        System.out.println(-1);

    }
    static class Node{
        int x;
        int y;
        int total;
        Node(int x,int y, int total){
            this.x = x;
            this.y = y;
            this.total = total;
        }
    }
}
