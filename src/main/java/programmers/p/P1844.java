package programmers.p;

import java.util.Deque;
import java.util.LinkedList;

public class P1844 {

    public static void main(String[] args) {

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1}
        };

        Solution solution = new Solution();
        int result = solution.solution(maps);
        System.out.println(result); // Expected output: 11
    }

    static class Solution {
        private static final int[] dx = {0, 0, -1, 1};
        private static final int[] dy = {-1, 1, 0, 0};

        public int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;
            boolean[][] visited = new boolean[n][m];
            StringBuilder sb = new StringBuilder();
            Deque<int[]> deque = new LinkedList<>();
            deque.add(new int[]{0, 0, 1});
            visited[0][0] = true;

            while (!deque.isEmpty()) {
                int[] current = deque.poll();
                int x = current[0];
                int y = current[1];
                int cnt = current[2];

                if (x == n - 1 && y == m - 1) {
                    return cnt;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        deque.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }

            return -1;
        }
    }
}
