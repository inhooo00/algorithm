package programmers.p;

// 보류..

public class P388352 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};
        System.out.println(solution.solution(n, q, ans));
    }

    static class Solution {
        public int solution(int n, int[][] q, int[] ans) {
            int answer = 0;
            return answer;
        }
    }
}
