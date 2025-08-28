package programmers.p;

import java.util.*;
class P42884 {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (a,b)-> {
            return a[1] - b[1];
        });
        int now = routes[0][1];
        for(int i=1;i<routes.length;i++){
            if(now <= routes[i][1] && now >= routes[i][0]){
                continue;
            }else {
                now = routes[i][1];
                answer++;
            }
        }
        // System.out.println(routes[0][0] + " " + routes[0][1]);
        // System.out.println(routes[1][0] + " " + routes[1][1]);
        // System.out.println(routes[2][0] + " " + routes[2][1]);
        return answer;
    }
}