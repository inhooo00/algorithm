package programmers.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P42578 {

    public static void main(String[] args) {
        String[][] clothes = {
            {"yellow_hat", "headgear"},
            {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}
        };
        // return : 5
        System.out.println(new Solution().solution(clothes));
    }

    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String , Integer> hashMap = new HashMap<>();

            for (int i = 0; i < clothes.length; i++) {
                hashMap.put(clothes[i][1],1 + hashMap.getOrDefault(clothes[i][1],0));
            }
            List<Integer> list = new ArrayList<>(hashMap.values());
            for (int i = 0; i < list.size(); i++) {
                answer *= list.get(i)+1;
            }

            return answer-1;
        }
    }
}
