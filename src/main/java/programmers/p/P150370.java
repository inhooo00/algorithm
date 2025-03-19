package programmers.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

// map으로 terms 저장. *28해서
// map으로 privacies 저장.
// 19 + 5*28 + 2021*12*28 계산해서 넣어두기.
// today랑 값 비교해서 기한 넘겼으면 배열에 추가.
public class P150370 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] answer = solution.solution(today, terms, privacies);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    static class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
            List<Integer> answer = new ArrayList<>();

            String[] strings = today.split("\\.");
            int todaySum =
                    Integer.parseInt(strings[0]) * 12 * 28 + Integer.parseInt(strings[1]) * 28 + Integer.parseInt(
                            strings[2]);

            Map<String, Integer> mapTerms = new HashMap<>();
            for (int i = 0; i < terms.length; i++) {
                String[] string = terms[i].split(" ");
                mapTerms.put(string[0], Integer.parseInt(string[1]) * 28);
            }

            for (int i = 0; i < privacies.length; i++) {
                String[] string = privacies[i].split(" ");
                String[] integers = string[0].split("\\.");
                int sum =
                        Integer.parseInt(integers[0]) * 12 * 28 + Integer.parseInt(integers[1]) * 28 + Integer.parseInt(
                                integers[2]);

                if (sum + mapTerms.get(string[1]) <= todaySum) {
                    answer.add(i + 1);
                }
            }

            Collections.sort(answer);
            int[] arr = answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            return arr;
        }
    }
}
