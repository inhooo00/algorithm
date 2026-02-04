//package programmers.p;
//
//public class P12952 {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int n = 4; // return 2
//        System.out.println(solution.solution(n));
//    }
//
//    static class Solution {
//        public int solution(int n) {
//            int answer = 0;
//            Integer[][] pan = new Integer[n][n];
//            int count = 0;
//            backTracking(count, n, answer);
//
//            return answer;
//        }
//
//        private void backTracking(int count, int n, int answer) {
//            if (count == n) {
//                answer++;
//                return;
//            }
//            for ()
//        }
//
//        private boolean isSafe(Integer[][] pan, int n, int 행, int 열) {
//            // 같은 열이 겹치는지
//            for (int i = 0; i < 행; i++) {
//                if (pan[i][열] == 1) return false;
//            }
//
//            // 왼쪽 위 대각선
//            for (int i = 행 - 1, j = 열 - 1; i >= 0 && j >= 0; i--, j--) {
//                if (pan[i][j] == 1) return false;
//            }
//
//            // 오른쪽 위 대각선
//            for (int i = 행 - 1, j = 열 + 1; i >= 0 && j < n; i--, j++) {
//                if (pan[i][j] == 1) return false;
//            }
//
//            return true;
//        }
//    }
//}
