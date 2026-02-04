package programmers.p;

import java.util.HashMap;
import java.util.Map;

public class P131127 {

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 4, 1};
        String[] discount = {
                "chicken", "apple", "apple", "banana", "rice",
                "apple", "pork", "banana", "pot", "banana",
                "pork", "rice", "banana", "apple"
        };

        System.out.println(new Solution().solution(want, number, discount));
    }

    static class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            int days = 10;

            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < want.length; i++){
                map.put(want[i], number[i]);
            }

            for(int i = 0; i < discount.length - days + 1; i++) {
                Map<String, Integer> dMap = new HashMap<>();

                for(int j = 0; j < days; j++){
                    dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
                }

                Boolean isIdentical = true;

                for(String key : map.keySet()){
                    if(map.get(key) != dMap.get(key)){
                        isIdentical = false;
                        break;
                    }
                }

                answer += isIdentical ? 1 : 0;
            }

            return answer;
        }
    }
}
