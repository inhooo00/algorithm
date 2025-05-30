package programmers.p;

public class P12945 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public long solution(int n) {
            long[] answer = new long[n + 1];
            answer[0] = 0;
            answer[1] = 1;

            for (int i = 2; i <= n; i++) {
                answer[i] = answer[i - 1] % 1234567 + answer[i - 2] % 1234567;
            }

            return answer[n] % 1234567;
        }
    }
}
