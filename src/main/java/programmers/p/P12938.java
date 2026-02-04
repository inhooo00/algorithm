package programmers.p;

import java.util.*;
class P12938 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int 몫 = s/n;
        int 나머지 = s%n;
        for(int i=0; i<나머지;i++){
            answer[i] = 몫+1;
        }
        for(int i=나머지;i<n;i++){
            answer[i] = 몫;
        }
        Arrays.sort(answer);
        if(answer[0]==0) return new int[]{-1};
        return answer;
    }
}