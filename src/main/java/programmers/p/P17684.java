package programmers.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P17684 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        List<Integer> result = solution.solution(msg);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        public List<Integer> solution(String msg) {
            List<Integer> list = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            int index = 1;
            for (char i = 'A'; i <= 'Z'; i++) {
                map.put(String.valueOf(i), index++);
            }
            int len = 0;
            for (int i = 0; i < msg.length(); i = len - 1) {
                boolean check = false;
                for (int j = i + 1; j <= msg.length(); j++) {
                    len = j;
                    if (map.get(msg.substring(i, j)) == null) {
                        check = true;
                        break;
                    }
                }
                if (check) { // 맵에 값이 없어
                    list.add(map.get(msg.substring(i, len - 1)));
                } else // 끝까지 맵에 값이 있으면
                {
                    list.add(map.get(msg.substring(i, len)));
                }
                map.put(msg.substring(i, len), index++);
                if (!check && len == msg.length()) {
                    break;
                }
            }
            return list;
        }
    }
}
