package programmers.p;

// 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재
// 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
// 아차상(#) 당첨 시 해당 점수는 마이너스된다.

import java.util.ArrayList;
import java.util.List;

public class P17682 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String dartResult = "1S2D*3T"; //1D2S#10S
        System.out.println(solution.solution(dartResult));
    }

    static class Solution {
        public int solution(String dartResult) {
            int answer = 0;
            List<Integer> result = new ArrayList<>();
            String number = "";

            for (int i = 0; i < dartResult.length(); i++) {
                switch (dartResult.charAt(i)) {
                    case 'S':
                        result.add((int) Math.pow(Integer.parseInt(number), 1));
                        number = "";
                        break;
                    case 'D':
                        result.add((int) Math.pow(Integer.parseInt(number), 2));
                        number = "";
                        break;
                    case 'T':
                        result.add((int) Math.pow(Integer.parseInt(number), 3));
                        number = "";
                        break;
                    case '*':
                        if (result.size() == 1) {
                            result.set(0, result.get(0) * 2);
                        } else if (result.size() == 2 || result.size() == 3){
                            result.set(result.size() - 2, result.get(result.size() - 2) * 2);
                            result.set(result.size() - 1, result.get(result.size() - 1) * 2);
                        }
                        break;
                    case '#':
                        result.set(result.size() - 1, result.get(result.size() - 1) * -1);
                        break;
                    default:
                        number += dartResult.charAt(i);
                        break;
                }
            }
            answer = result.get(0) + result.get(1) + result.get(2);
            return answer;
        }
    }
}
