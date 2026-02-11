package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 겹치지 않게 전선 연결
// 전선 길이의 합 구하기.
// 우선순위 연결 개수, 길이 합 최소.

public class S1767_프로세서연결하기 {
    static int[][] field;
    static boolean[][] core;
    static List<Node> list;
    static int min;
    static int N;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static int maxCoreNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            field = new int[N][N];
            core = new boolean[N][N];
            maxCoreNum = Integer.MIN_VALUE;
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    field[j][k] = Integer.parseInt(input[k]);
                    if (field[j][k]== 1) list.add(new Node(j,k));
                }
            }
            dfs(0,0,0);

            System.out.println("#"+i+" " +min);
        }
    }

    private static void dfs(int depth, int count, int coreNum) {
        // 끝까지 봤고, coreNum이 최대값일 때, 값 갱신
        if (depth == list.size()) {
            if (coreNum > maxCoreNum) {
                maxCoreNum = coreNum;
                min = count;
            } else if (coreNum == maxCoreNum) {
                min = Math.min(min, count);
            }
            return;
        }

        Node now = list.get(depth);

        // 이미 연결된 상태
        if (now.x == 0 || now.x == N-1 || now.y == 0 || now.y == N-1) {
            dfs(depth + 1, count, coreNum + 1);
            return;
        }

        // 각 방향으로 쭉 가보기
        for (int[] row : rows) {
            int newX = now.x;
            int newY = now.y;
            boolean check = false;
            int ct = 0;

            while (true) {
                newX += row[0];
                newY += row[1];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    check = true;
                    break;
                }

                if (field[newX][newY] != 0) {
                    check = false;
                    break;
                }
                ct++;
            }

            if (check) {
                int fx = now.x;
                int fy = now.y;
                for (int i = 0; i < ct; i++) {
                    fx += row[0];
                    fy += row[1];
                    field[fx][fy] = 2;
                }
                dfs(depth+1,count+ct,coreNum+1);
                fx = now.x;
                fy = now.y;
                for (int i = 0; i < ct; i++) {
                    fx += row[0];
                    fy += row[1];
                    field[fx][fy] = 0;
                }

            }
        }

        // 아무 연결 안 할 때
        dfs(depth +1, count, coreNum);
    }

    static class Node{
        int x,y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
