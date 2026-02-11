package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 같은 높이 1
// 높으 높이 차이*2
// 낮은 높이 0
// 최소값을 저장하는 배열이 따로 있어야할듯
public class S_산악구조 {
    static int N;
    static int[][] field;
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    static int answer;
    static int[][] minArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            N = Integer.parseInt(br.readLine());
            field = new int[N][N];
            minArr = new int[N][N];
            for (int j = 0; j < N; j++) {
                Arrays.fill(minArr[j],Integer.MAX_VALUE);
            }
            answer = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    field[j][k] = Integer.parseInt(input[k]);
                }
            }
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(new Node(0,0));
            minArr[0][0] = 0;
            while (!deque.isEmpty()){
                Node now = deque.remove();
                int next;
                for(int[] row : rows){
                    int newX = now.x + row[0];
                    int newY = now.y + row[1];
                    if (newX < 0 || newX >= N || newY < 0 || newY >= N) continue;

                    if (field[now.x][now.y] > field[newX][newY]) next = 0;
                    else if (field[now.x][now.y] == field[newX][newY]) next = 1;
                    else next = (field[newX][newY]-field[now.x][now.y])*2;
                    if (minArr[newX][newY]>=minArr[now.x][now.y]+next)deque.add(new Node(newX, newY));
                    minArr[newX][newY] = Math.min(minArr[newX][newY], minArr[now.x][now.y]+next);
                }
            }
            System.out.println("#"+i+" "+minArr[N-1][N-1]);
        }
    }
    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
