package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 순열 구하면서 멘헤튼 거리 누적하기
// 몬스터 번호랑 고객 번호가 매칭되는 것만 되도록 가지치기
public class S_헌터 {
    static int N;
    static Node[] customer;
    static Node[] monster;
    static boolean[] visitedM;
    static boolean[] visitedC;
    static int[][] field;
    static int num;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            field = new int[N][N];
            num = 0;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    field[j][k] = Integer.parseInt(input[k]);
                    if (field[j][k] > 0) {
                        num++;
                    }
                }
            }
            customer = new Node[num + 1];
            monster = new Node[num + 1];
            visitedM = new boolean[num + 1];
            visitedC = new boolean[num + 1];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (field[j][k] > 0) {
                        monster[field[j][k]] = new Node(j, k);
                    } else if (field[j][k] < 0) {
                        customer[-field[j][k]] = new Node(j, k);
                    }
                }
            }

            dfs(0, 0, new Node(0, 0));
            System.out.println("#"+i+" "+min);
        }
    }

    // 몬스터랑 고객 순열
    private static void dfs(int depth, int total, Node node) {
        if (depth == num * 2) {
            min = Math.min(min, total);
            return;
        }
        // 몬스터는 그냥 잡기. 고객은 몬스터 잡았는지 확인하기
        for (int i = 1; i <= num * 2; i++) {

            // 몬스터 잡을 때
            if (i <= num) {
                if (visitedM[i]) {
                    continue;
                }
                int dist = Math.abs(node.x - monster[i].x) + Math.abs(node.y - monster[i].y);
                visitedM[i] = true;
                dfs(depth + 1, total + dist, monster[i]);
                visitedM[i] = false;

            } else { // 고객 방문할 때
                if (visitedC[i-num] || !visitedM[i-num]) {
                    continue;
                }
                int dist = Math.abs(node.x - customer[i-num].x) + Math.abs(node.y - customer[i-num].y);
                visitedC[i-num] = true;
                dfs(depth + 1, total + dist, customer[i-num]);
                visitedC[i-num] = false;
            }
        }


    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
