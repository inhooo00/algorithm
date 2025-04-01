package programmers.p;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P42584 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {1, 2, 3, 2, 3};
        // [4, 3, 1, 1, 0]
        System.out.println(Arrays.toString(solution.solution(prices)));
    }
    static class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < prices.length; i++) {
                if (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int index = stack.pop();
                    answer[index] = i - index; // 가격이 떨어진 시간 계산
                }
                stack.push(i);
            }

            return answer;
        }
    }
}
