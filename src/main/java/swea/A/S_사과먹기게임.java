package swea.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 오른쪽 위 1
// 오른쪽 아래 2
// 왼쪽 3
// 숫자마다 위치와 방향을 파악해서 더해주기.
public class S_사과먹기게임 {
    static int N;
    static int[][] field;
    static int max;
    static Map<Integer,Node> map;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            map = new HashMap<>();
            max= 0;
            answer = 0;
            N = Integer.parseInt(br.readLine());
            field = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] input = br.readLine().split("");
                for (int k = 0; k < N; k++) {
                    field[j][k] = Integer.parseInt(input[k]);
                    if (field[j][k]!=0) {
                        max = Math.max(max,field[j][k]);
                        map.put(field[j][k], new Node(j,k));
                    }
                }
            }
            map.put(0,new Node(0,0));
            // 우 0 하 1 좌 2 상 3
            int start = 0;
            for (int j = 0; j < max; j++) {
                // 우상, 우하 , 좌 로 판별
                start =  move(j,start);
            }
            System.out.println(answer);
        }
    }
    // answer 값 증가, 방향 변경
    private static int move(int j, int start) {

        Node now = map.get(j);
        Node next = map.get(j+1);
        // 우
        if (start ==0){
            if (now.x < next.x && now.y < next.y) {
                answer += 1;
                return 1;
            }
            else if (now.x < next.x && now.y > next.y) {
                answer += 2;
                return 2;
            }
            else {
                answer += 3;
                return 3;
            }
        } // 하
        else if (start ==1){
            if (now.x < next.x && now.y > next.y) {
                answer += 1;
                return 2;
            }
            else if (now.x > next.x && now.y > next.y) {
                answer += 2;
                return 3;
            }
            else {
                answer += 3;
                return 0;
            }
        }
        else if (start == 2){
            if (now.x > next.x && now.y > next.y) {
                answer += 1;
                return 3;
            }
            else if (now.x < next.x && now.y > next.y) {
                answer += 2;
                return 0;
            }
            else {
                answer += 3;
                return 1;
            }
        } else {
            if (now.x > next.x && now.y < next.y) {
                answer += 1;
                return 0;
            }
            else if (now.x < next.x && now.y > next.y) {
                answer += 2;
                return 1;
            }
            else {
                answer += 3;
                return 2;
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
