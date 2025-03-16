package programmers.p;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class P118666 {

    // 1번 지표	라이언형(R), 튜브형(T)
    //2번 지표	콘형(C), 프로도형(F)
    //3번 지표	제이지형(J), 무지형(M)
    //4번 지표	어피치형(A), 네오형(N)

    // survey	choices	result
    //["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
    //["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"

    // hashMap으로 각 영어 포인트 증가시키기
    // 정렬하고 
    // 특정 문자열인지 판단하고 맞으면 그 hashmap들 삭제 -> 다시 정렬
    // 4번 반복
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] survey = {
                "AN", "CF", "MJ", "RT", "NA"
        };
        int[] choices = {5, 3, 2, 7, 5};
        System.out.println(solution.solution(survey, choices));
    }

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            String answer = "";
            Integer[][] arr = {{0, 0}, {1, 3}, {2, 2}, {3, 1}, {4, 0}, {5, 1}, {6, 2}, {7, 3}};
            LinkedHashMap<Character, Integer> answers = new LinkedHashMap();
            answers.put('R', 0);
            answers.put('T', 0);
            answers.put('C', 0);
            answers.put('F', 0);
            answers.put('J', 0);
            answers.put('M', 0);
            answers.put('A', 0);
            answers.put('N', 0);

            for (int i = 0; i < survey.length; i++) {
                if (choices[i] < 4) {
                    answers.put(survey[i].charAt(0), answers.getOrDefault(survey[i].charAt(0), 0) + arr[choices[i]][1]);
                } else if (choices[i] > 4) {
                    answers.put(survey[i].charAt(1), answers.getOrDefault(survey[i].charAt(1), 0) + arr[choices[i]][1]);
                }
            }

            StringBuilder result = new StringBuilder();

            // 1번 지표 (R, T)
            result.append(answers.get('R') >= answers.get('T') ? 'R' : 'T');
            // 2번 지표 (C, F)
            result.append(answers.get('C') >= answers.get('F') ? 'C' : 'F');
            // 3번 지표 (J, M)
            result.append(answers.get('J') >= answers.get('M') ? 'J' : 'M');
            // 4번 지표 (A, N)
            result.append(answers.get('A') >= answers.get('N') ? 'A' : 'N');
            System.out.println(answers);
            return result.toString();
        }
    }
}
