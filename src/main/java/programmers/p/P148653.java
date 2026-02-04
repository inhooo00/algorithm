package programmers.p;

public class P148653 {
    // 각 자리마다 5이하면 그대로, 6부터는 10-{값}하고 앞자리 +1로 처리 반복.
    static int answer;

    public static void main(String[] args) {
        Solution sol = new P148653().new Solution();
        System.out.println(sol.solution(2554));
    }

    class Solution {
        public int solution(int storey) {
            answer = 0;
            int count = 0;
            for (int i = 1; i <= String.valueOf(storey).length(); i++) {
                int now = String.valueOf(storey).charAt(String.valueOf(storey).length() - i) - '0';
                System.out.println(now);
                if (isDown(now, count)) {

                    count = 0;
                } else {
                    count = 1;
                }
            }
            return answer;
        }
    }

    private boolean isDown(int num, int count) {
        if (num + count <= 5) {
            answer += (num + count);
            return true;
        }
        answer += (10 - num + count);
        return false;
    }
}
