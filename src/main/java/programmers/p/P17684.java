package programmers.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17684 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String msg = "KAKAO";
        List<Integer> result = solution.solution(msg);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public List<Integer> solution(String msg) {
            List<Integer> answer = new ArrayList<>();
            Map <String, Integer> map = new HashMap<>();
            int index = 1;
            for(char c = 'A'; c <= 'Z'; c++)
                map.put(String.valueOf(c), index++);

            int len = 0;
            for (int i = 0; i < msg.length(); i = len - 1) {
                boolean check = false;
                for (int j = i+1; j < msg.length(); j++) {
                    len = j;
                    if (map.get(msg.substring(i,j))== null) {
                        check = true;
                        break;
                    }
                }
                if (!check) answer.add(map.get(msg.substring(i,len)));
                else answer.add(map.get((msg.substring(i, len - 1))));
                map.put(msg.substring(i,len),index++);

            }
            return answer;
        }
    }
}
