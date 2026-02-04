package programmers.p;

import java.util.ArrayDeque;
import java.util.Deque;

public class P131704 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] order = {4, 3, 1, 2, 5};
        int result = solution.solution(order);
        System.out.println(result); // Expected output: 5
    }

    // 값이 맞지 않으면 스택에 넣기
    // 값이 맞으면 answer 더하기
    // 값이 이전 값보다 크고, 스택에도 없으면 종료.
    static class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Deque<Integer> subDeque = new ArrayDeque<>();

            for (int i = 1; i <= order.length; i++) {
                subDeque.push(i);
                while (!subDeque.isEmpty() && subDeque.peek() == order[answer]) {
                    subDeque.pop();
                    answer++;
                }
            }

            return answer;
        }
    }
}
