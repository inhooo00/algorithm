package jobda;

import java.util.*;
class  Star {
    public int[][] solution(int N) {
        int[][] answer = new int[N][N];
        for(int i=0;i<answer.length;i++){
            Arrays.fill(answer[i],1);
        }

        for(int i=0;i<=N/2;i++){
            answer[i][i+N/2] = 0;
            answer[i][N/2-i] = 0;
        }
        for(int i=N/2+1;i<N-1;i++){ // 3 , 4 5
            answer[i][N+N/2-i-1] = 0;
            answer[i][i-N/2] = 0;
        }
        answer[N-1][N/2] = 0;
        return answer;
    }
}
