package programmers.p;

public class P340202 {

    static class Solution {
        public int solution(int storage, int usage, int[] change) {
            int total_usage = 0;
            for (int i = 0; i < change.length; i++) {
                usage += (usage * change[i] / 100);
                total_usage += usage;
                if (total_usage > storage) {
                    return i;
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int storage = 1000; // 총 스토리지 용량
        int usage = 100;    // 초기 사용량
        int[] change = {20, 10, -10, 30}; // 월별 사용량 증감률 (%)

        int result = solution.solution(storage, usage, change);
        System.out.println("초과한 달: " + result); // 초과한 달 출력
    }
}
