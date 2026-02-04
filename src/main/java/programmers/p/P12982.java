package programmers.p;

import java.util.Arrays;

public class P12982 {
    public static void main(String[] args) {
        // Example usage
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        P12982.Solution solution = new Solution();
        int result = solution.solution(d, budget);
        System.out.println(result); // Expected output: 3
    }

    static class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            int count = 0;
            Arrays.sort(d);
            for (int num : d) {
                count += num;
                if (count > budget) {
                    break;
                }
                answer++;
            }
            return answer;

        }
    }
}
