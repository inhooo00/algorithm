package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 길 있는지 확인
// 1은 벽 0은 길 2는 출발점 3은 도착점
// 갈 수 있으면 1 없으면 0
// bfs ㄱㄱ
public class B1226_미로1 {
    static int[][] rows = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int T = Integer.parseInt(br.readLine());
            int[][] field = new int[16][16];
            int[] start = new int[2];
            int[] end = new int[2];
            for (int j = 0; j < 16; j++) {
                String[] input = br.readLine().split("");
                for (int k = 0; k < 16; k++) {
                    field[j][k] = Integer.parseInt(input[k]);
                    if (field[j][k]==2) {
                        start[0] = j;
                        start[1] = k;
                    }else if(field[j][k]==3){
                        end[0] = j;
                        end[1] = k;
                    }
                }
            }

            Deque<Node> deque = new ArrayDeque<>();
            deque.add(new Node(start[0],start[1]));
            boolean check = false;
            while (!deque.isEmpty()){
                Node now = deque.remove();
                for (int[] row : rows){
                    int newX = now.x + row[0];
                    int newY = now.y + row[1];
                    if (newX < 0 || newX >= 16 || newY < 0 || newY >=16) continue;
                    if (field[newX][newY]==0){
                        field[newX][newY] = 1;
                        deque.add(new Node(newX, newY));
                    }else if(field[newX][newY]==3) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) {
                System.out.println("#"+i+" 1");
            }else {
                System.out.println("#"+i+" 0");
            }
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
