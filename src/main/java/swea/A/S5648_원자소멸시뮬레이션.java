package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class S5648_원자소멸시뮬레이션 {
    static int[][] dir = {
            {0, 1},  // 상
            {0, -1}, // 하
            {-1, 0}, // 좌
            {1, 0}   // 우
    };
    static Map<Integer, Integer> map;
    static List<Node> list;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            map = new HashMap<>();
            list = new ArrayList<>();
            result = 0;

            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                list.add(new Node(y * 2, x * 2, d, k));
            }

            while (!list.isEmpty()) {
                List<Node> removeList = new ArrayList<>();
                map.clear();

                for (Node node : list) {
                    node.x += dir[node.to][0];
                    node.y += dir[node.to][1];

                    if (isOut(node.x, node.y)) continue;

                    int key = (node.x + 2000) * 5000 + (node.y + 2000);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }

                for (Node node : list) {
                    if (isOut(node.x, node.y)) {
                        removeList.add(node);
                        continue;
                    }

                    int key = (node.x + 2000) * 5000 + (node.y + 2000);
                    if (map.get(key) >= 2) {
                        result += node.weight;
                        removeList.add(node);
                    }
                }

                list.removeAll(removeList);
            }
            System.out.println("#" + i + " " + result);
        }
    }

    static boolean isOut(int x, int y) {
        return x > 2000 || x < -2000 || y > 2000 || y < -2000;
    }

    static class Node {
        int x, y, to, weight;
        Node(int x, int y, int to, int weight) {
            this.x = x;
            this.y = y;
            this.to = to;
            this.weight = weight;
        }
    }
}