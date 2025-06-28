package programmers.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P17677 {
    public static void main(String[] args) {
//    2개씩 짤라서 저장;
//    특수문자 공ㅂ잭시 버림;
//    교집합, 합집합 개수 구하기;
//    유사도 계산. 65536 곱하고 소수점 아래 버리기. 유사도는 교집합/합집합. 다중집합시 min / max 처리.

        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        Solution solution = new Solution();
        int answer = solution.solution(str1, str2);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(String str1, String str2) {
            Map<String, Integer> first = makeMultiSet(str1);
            Map<String, Integer> second = makeMultiSet(str2);

            if (first.size() == 0 && second.size() == 0) {
                return 65536;
            }
            Set<String> firstKeySet = first.keySet();
            Set<String> secondKeySet = second.keySet();

            int intersection = 0; // 교집합은 min 구해서 누적 넣어주고
            for (String key : firstKeySet) {
                if (!second.containsKey(key)) {
                    continue;
                }
                intersection += Math.min(first.get(key), second.get(key));
            }

            int union = -1 * intersection; // 합집합은 전부 더하고 교집합 값들만 빼면 됨
            for (String key : firstKeySet) {
                union += first.get(key);
            }
            for (String key : secondKeySet) {
                union += second.get(key);
            }
            return (int) ((intersection / (union * 1.0)) * 65536);

        }

        public Map<String, Integer> makeMultiSet(String str) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length() - 1; i++) {
                if (!Character.isAlphabetic(str.charAt(i)) || !Character.isAlphabetic(str.charAt(i + 1))) {
                    continue;
                }

                String key =
                        String.valueOf(str.charAt(i)).toLowerCase() + String.valueOf(str.charAt(i + 1)).toLowerCase();
                map.put(key, map.getOrDefault(key, 0)+1);
            }
            return map;
        }
    }
}
