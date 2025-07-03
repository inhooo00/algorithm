package programmers.p;

public class P17687 {

    public static void main(String[] args) {
        Solution solution = new P17687().new Solution();
        System.out.println(solution.solution(2, 4, 2, 1)); // "0111"
        System.out.println(solution.solution(16, 16, 2, 1)); // "02468ACE11111111"
    }

    class Solution {
        public String solution(int n, int t, int m, int p) {
            // 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p 가 주어진다.

            String answer = "";
            int len = 0;
            int tube = p;
            for (int i = 0; i < t * m; i++) {
                String num = Integer.toString(i, n).toUpperCase();
                for (int j = 0; j < num.length(); j++) {
                    len++;
                    if (len == tube) {
                        answer += num.substring(j, j + 1);
                        if (answer.length() == t) break;
                        tube += m;
                    }
                }
            }
            return answer;
        }
    }
}
