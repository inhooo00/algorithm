package programmers.p;

import java.util.HashMap;
import java.util.Map;

public class P152996 {
    // 1:1 2:3 2:4 3:4 3:2 4:2 4:3
    public static void main(String[] args) {
        Solution solution = new P152996().new Solution();
        int[] weights = {100, 180, 360, 100, 270};
        System.out.println(solution.solution(weights));
    }

    static int[][] arr = {
            {1, 1},
            {2, 3},
            {2, 4},
            {3, 4},
            {3, 2},
            {4, 2},
            {4, 3}
    };

    class Solution {
        public long solution(int[] weights) {
            Map<Long,Integer> map = new HashMap<>();
            long answer = 0;
            for(int weight : weights){
                for(int[] ar : arr){
                    long target = (long) weight * ar[0] / ar[1];
                    if(weight * ar[0] % ar[1] != 0) continue;
                    answer += map.getOrDefault(target,0);
                }

                map.put((long)weight,map.getOrDefault((long)weight,0)+1);
            }
            return answer;
        }
    }
}
