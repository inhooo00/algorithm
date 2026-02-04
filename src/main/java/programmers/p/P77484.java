package programmers.p;

import java.util.Arrays;
import java.util.List;

public class P77484 {

    // 모르는 부분은 0으로 처리.
    // 최대 등수와 최소 등수 반환
    // ex)
    //[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
    //[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
    //[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]

    // for문으로 0 제외 순환 -> 맞는 거 확인
    // 최소 등수 인지하고 최대 등수는 0 개수로 판별

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        // [3, 5]
        System.out.println(Arrays.toString(solution.solution(lottos, win_nums)));
    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int countZ = 0; // 0 개수
            int countNum = 0; // 맞춘 숫자
            for (int i = 0; i < lottos.length; i++) {
                if (lottos[i] == 0) {
                    countZ++;
                }
            }

            for (int i = 0; i < lottos.length; i++) {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        countNum++;
                    }
                }
            }

            if (countZ == 6 || countNum == 1 || countNum == 0) { // 최소 등수 구하기
                answer[1] = 6;
            } else {
                answer[1] = 7 - countNum;

            }

            if (answer[1] - countZ > 1) { // 최대 등수 구하기
                answer[0] = answer[1] - countZ;
            } else {
                answer[0] = 1;
            }

            return answer;
        }
    }
}
