package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import javax.swing.plaf.SpinnerUI;

public class B15686_치킨배달 {
    static int  N,M;
    static int[][] field;
    static List<Node> home = new ArrayList<>();
    static List<Node> ck = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int[][] rows = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]); // 최대 치킨 가게
        field = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String[] input2 = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                field[i][j] = Integer.parseInt(input2[j]);
                if (field[i][j]==1) home.add(new Node(i,j));
                else if(field[i][j]==2) ck.add(new Node(i,j));
            }
        }

        // dfs로 M개의 치킨비을 고르는 조합을 구하고 멘해튼 거리 갱신해서 최대가 나오도록.
        dfs(0,0); // start, depth(현재 깊이)
        System.out.println(answer);
    }
    static void dfs(int start, int depth){
        if (depth==M){
            int calNum = cal();
            answer = Math.min(answer, calNum);
            return;
        }
        for(int i=start;i<ck.size();i++){
            Node nowCK = ck.get(i);
            if (!visited[nowCK.x][nowCK.y]){
                visited[nowCK.x][nowCK.y] = true;
                dfs(i+1,depth+1);
                visited[nowCK.x][nowCK.y] = false;
            }

        }
    }
    // 현재 상황에서 모든 집을 bfs 돌렸을 때 합을 리턴하자.
    static int cal(){
        int rt = 0;

        for(Node n : home){ // 집 리스트 순회
            boolean[][] homeVisited = new boolean[N][N]; // 집이 들린 곳은 안 들리게
            Deque<Node> deque = new ArrayDeque<>();
            deque.add(n);
            homeVisited[n.x][n.y] = true;
            int targetX = 0;
            int targetY = 0;
            int count = 0; // 지금 검사하는 집에 대한 카운트
            // 해당 집에 대해서 bfs를 통해 가장 가까운 치킨집을 찾자.
            while(!deque.isEmpty()){
                boolean check = false; // 도착여부
                Node now = deque.remove();

                for(int[] r : rows){
                    int newX = r[0] + now.x;
                    int newY = r[1] + now.y;
                    if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                    if (!homeVisited[newX][newY]){
                        if (visited[newX][newY]) {
                            check = true;
                            targetX = newX;
                            targetY = newY;
                            break;
                        }
                        homeVisited[newX][newY] = true;
                        deque.add(new Node(newX, newY));
                    }
                }
                if (check) {
                    break;
                }
            }

            rt +=Math.abs(targetX-n.x) + Math.abs(targetY-n.y);
        }
        return rt;
    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
