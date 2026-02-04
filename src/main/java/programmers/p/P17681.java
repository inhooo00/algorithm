package programmers.p;

import java.util.Arrays;

public class P17681 {
    // 1. 숫자 해독 -> 2진수로
    // 2. n번씩 각 자리숫자를 비교해서 1과 0으로 처리
    // 3. 처리된 값으로 1은 #으로, 0은 공백으로 답 처리

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(n, arr1, arr2)));
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            String[] arr1To = new String[n];
            String[] arr2To = new String[n];

            for (int i = 0; i < n; i++) {
                arr1To[i] = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(" ", "0");
                arr2To[i] = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(" ", "0");
            }

            for (int i = 0; i < n; i++) {
                answer[i] = "";
                for (int j = 0; j < n; j++) {
                    if (arr1To[i].charAt(j) == '1' || arr2To[i].charAt(j) == '1') {
                        answer[i] += "#";
                    } else {
                        answer[i] += " ";
                    }
                }
            }
            return answer;
        }
    }
}
