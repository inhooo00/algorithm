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

        int[][] directions = {
                {-1, 0}, // 상 (x-1)
                {1, 0},  // 하 (x+1)
                {0, -1}, // 좌 (y-1)
                {0, 1}   // 우 (y+1)
        };

        public int solution(int[][] maps) {
            int a = maps.length;
            int b = maps[0].length;
            Deque<int[]> deque = new LinkedList();
            boolean[][] visited = new boolean[a][b];
            deque.add(new int[]{0,0,1});
            visited[0][0] = true;

            while (!deque.isEmpty()) {
                int[] now = deque.poll();
                int x = now[0];
                int y = now[1];
                int cnt = now[2];

                if (x== a-1 && y== b-1) {
                    return cnt;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + directions[i][0];
                    int ny = y + directions[i][1];

                    if (nx>=0 && ny >=0 && !visited[nx][ny] && maps[nx][ny] ==1){
                        visited[nx][ny] = true;
                        deque.add(new int[] {nx, ny, cnt +1});
                    }

                }
            }
            return -1;
        }
    }
}
