package programmers.p;

import java.util.*;
class P118667 {
    public long solution(int[] queue1, int[] queue2) {
        long sum1 = 0 , sum2 = 0;
        int[] linkQ = new int[queue1.length * 2];
        for (int i =0 ; i<queue1.length;i++){
            linkQ[i] = queue1[i];
            sum1 += queue1[i];
        }

        for (int i =0 ; i<queue2.length;i++){
            linkQ[i+queue2.length] = queue2[i];
            sum2 += queue2[i];
        }
        if((sum1 + sum2)%2==1) return -1;
        long target = (sum1 + sum2)/2;

        int count = 0;
        int start = 0;
        int end = queue1.length;
        while(count < queue1.length*4){
            if(sum1 == target) return count;
            if(start==queue1.length*2|| end == queue1.length*2) return -1;
                // if(target%2==1) return -1;
            else if(sum1 > target){
                //System.out.println(sum1);
                sum1 -= linkQ[start];
                start++;
                count++;
            }else{
                //System.out.println(sum1);
                sum1 += linkQ[end];
                end++;
                count++;
            }
        }
        return -1;
    }
}