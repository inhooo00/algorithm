package programmers.p;

import java.util.*;
class P12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        // 1 3 5 7
        // 2 2 6 8 
        PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
        for(int a : A) q1.add(a);
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int b : B) q2.add(b);

        while(!q1.isEmpty()){
            int num1 = q1.poll();
            int num2 = q2.poll();
            if(num1 < num2) answer++;
            else q2.add(num2);
        }

        return answer;
    }
}