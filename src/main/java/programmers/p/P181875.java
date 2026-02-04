package programmers.p;

import java.util.Arrays;
import java.util.Locale;

public class P181875 {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String[] arr = {"AAA", "BBB", "CCC", "DDD"};
//        System.out.println(Arrays.toString(solution.solution(arr)));
//    }

    static class Solution {
        public String[] solution(String[] strArr) {
            String[] answer = strArr;

            for (int i = 0; i < strArr.length; i++) {
                if (i % 2 == 0) { // 짝수일 때
                    answer[i] = answer[i].toLowerCase();
                } else { // 홀수일 때
                    answer[i] = answer[i].toUpperCase();
                }
            }

            return answer;
        }
    }
}
