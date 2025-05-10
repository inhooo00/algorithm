package programmers.p;

public class P12911 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 78;
        System.out.println(solution.solution(n));
        n = 15;
        System.out.println(solution.solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int answer = n;
            String nString = Integer.toBinaryString(n);
            int nCount = 0;
            int count = 0;
            for (int i = 0; i < nString.length(); i++) {
                if (nString.charAt(i) == '1') {
                    nCount++;
                }
            }

            while (nCount != count) {
                count = 0;
                answer += 1;
                String answerString = Integer.toBinaryString(answer);

                for (int i = 0; i < answerString.length(); i++) {
                    if (answerString.charAt(i) == '1') {
                        count++;
                    }
                }
            }
            return answer;
        }
    }
}
