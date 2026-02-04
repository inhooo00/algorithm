package programmers.p;

import java.util.*;
class P12927 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue =  new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) queue.add(work);

        for(int i=0 ;i<n;i++){
            int num = queue.poll();
            if(num==0) break;
            queue.add(num-1);
        }
        System.out.println(queue);
        for(int q : queue) answer+= (q*q);
        return answer;
    }
}