package BJ.gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class B14226_이모티콘 {
    static int S;
    static boolean[][] visited = new boolean[1001][1001]; // [현재 위치][카피한 숫자]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(1, 0, 0));
        visited[1][0] = true;
        while (!deque.isEmpty()) {
            Node now = deque.remove();
            if (now.num == S) {
                System.out.println(now.count);
                break;
            }
            // 복사
            if (!visited[now.num][now.num]) {
                visited[now.num][now.num] = true;
                deque.add(new Node(now.num, now.count + 1, now.num));
            }

            // 붙여넣기
            if (now.copy > 0 && now.num + now.copy <= 1000) {
                if (!visited[now.num + now.copy][now.copy]) {
                    visited[now.num + now.copy][now.copy] = true;
                    deque.add(new Node(now.num + now.copy, now.count + 1, now.copy));
                }
            }

            // 삭제
            if (now.num > 1) {
                if (!visited[now.num - 1][now.copy]) {
                    visited[now.num - 1][now.copy] = true;
                    deque.add(new Node(now.num - 1, now.count + 1, now.copy));
                }
            }
        }
    }

    static class Node {
        int num;
        int count;
        int copy;

        Node(int num, int count, int copy) {
            this.num = num;
            this.count = count;
            this.copy = copy;
        }
    }
}
