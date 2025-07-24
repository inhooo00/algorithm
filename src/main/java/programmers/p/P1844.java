package programmers.p;

import java.util.ArrayDeque;
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

        public int solution2(int[][] maps) {
            int answer = 0;
            int[][] myMap = maps;
            int[][] move = {{1,0},{-1,0},{0,-1},{0,1}}; // 상하좌우
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(new Node(0,0,1));
            boolean[][] visited = new boolean[maps.length][maps[0].length];
            visited[0][0] = true;
            while(!deque.isEmpty()){
                Node now = deque.remove();
                // System.out.println("지금 삭제하는 노드"+ now.x +" " + now.y);

                if(now.x == maps[0].length-1 && now.y == maps.length-1) {
                    return now.count;
                }

                for(int i=0;i<4;i++){
                    int nowY = now.y + move[i][0];
                    int nowX = now.x + move[i][1];
                    // System.out.println(nowX +" " + nowY);
                    if( nowX <=maps[0].length-1 && nowX >=0 && nowY <=maps.length-1 && nowY >=0){
                        if(!visited[nowY][nowX]&& maps[nowY][nowX] == 1){
                            deque.add(new Node(nowY,nowX,now.count+1));
                            visited[nowY][nowX] = true;
                        }
                    }
                }// 상하좌우로 움직였는데 1로 안 막혀있고, 밖으로 안 나가고, 처음 visited일 때..
            }
            return -1;
        }

        static public class Node{
            int y;
            int x;
            int count;
            public Node(int y, int x, int count){
                this.y = y;
                this.x = x;
                this.count = count;
            }
        }
    }
}
