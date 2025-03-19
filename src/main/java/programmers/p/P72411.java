package programmers.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P72411 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] orders = {
                "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
        };
        int[] course = {2, 3, 4};
        // "AC", "ACDE", "BCFG", "CDE"
        System.out.println(Arrays.toString(solution.solution(orders, course)));
    }

    static class Solution {
        public String[] solution(String[] orders, int[] course) {
            for (int i = 0; i < orders.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                char[] chars = orders[i].toCharArray();
                Arrays.sort(chars);
                stringBuilder.append(chars);
                orders[i] = stringBuilder.toString();
            }

            List<String> results = new ArrayList<>();
            // 코스 길이에 따라 조합 생성
            for (int cutSize : course) {
                Map<String, Integer> orderCount = new HashMap<>();
                int max;

                // 각 주문에서 조합 생성 (백트래킹)
                for (String order : orders) {
                    if (order.length() >= cutSize) {
                        backtracking(order, "", 0, cutSize, orderCount);
                    }
                }

                // 최대 빈도 기반 결과 추가
                max = orderCount.values().stream().max(Integer::compareTo).orElse(0);
                if (max >= 2) {
                    for (Map.Entry<String, Integer> entry : orderCount.entrySet()) {
                        if (entry.getValue() == max) {
                            results.add(entry.getKey());
                        }
                    }
                }
                System.out.println(orderCount);
            }
            // 사전순 정렬 후 반환
            Collections.sort(results);
            return results.toArray(new String[0]);
        }

        private void backtracking(String order, String now, int index, int cutSize, Map<String, Integer> orderCount) {
            if (now.length() == cutSize) {
                orderCount.put(now, orderCount.getOrDefault(now, 0) + 1);
                return;
            }

            for (int i = index; i < order.length(); i++) {
                backtracking(order, now + order.charAt(i), i + 1, cutSize, orderCount);
            }
        }
    }
}