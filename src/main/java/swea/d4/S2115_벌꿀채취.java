package swea.d4;

import java.util.*;
import java.io.*;

// 2명이니 각각의 포지션별로 진행.
// 그 위치에서 구한 값으로 max 업데이트
class S2115_벌꿀채취 {
    static int N,M,C;
    static int[][] field;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int i=1;i<=TC;i++){
            max = -1;
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);
            field = new int[N][N];
            for(int j=0;j<N;j++){
                String[] input2 = br.readLine().split(" ");
                for(int k=0;k<N;k++){
                    field[j][k] = Integer.parseInt(input2[k]);
                }
            }

            // 포지션 설정
            for(int x1=0;x1<N;x1++){
                for(int y1=0;y1<=N-M;y1++){
                    for(int x2=x1;x2<N;x2++){
                        for(int y2=0;y2<=N-M;y2++){
                            if(x1 == x2 && y1+M > y2) continue;
                            int num1 = cal(new Node(x1,y1));
                            int num2 = cal(new Node(x2,y2));
                            max = Math.max(max, num1 + num2);
                        }
                    }
                }
            }
            System.out.println("#" + i + " " + max);
        }
    }
    private static int cal(Node node){
        int startX = node.x;
        int startY = node.y;
        int answer = 0;
        // 최대비용 = C , 가치 = n*n
        int[] dp = new int[C+1];
        for(int i = startY; i< startY+M ; i++){ // startY 기준 앞 M번째
            int nowNum = field[startX][i];
            for(int j = C; j > 0 ; j--){
                if (j-nowNum >= 0) dp[j] = Math.max(dp[j], dp[j-nowNum]+ nowNum*nowNum);
                answer = Math.max(answer,dp[j]);
            }
        }
        return answer;
    }
    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}