package programmers.p;

import java.util.ArrayDeque;
import java.util.Stack;

public class P12909 {

    public static void main(String[] args) {
        String s = "\")()(\"";

        Solution solution = new Solution();
        System.out.println(solution.solution(s));
    }

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> deque = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (!deque.isEmpty() && deque.peek().equals('(') && s.charAt(i) == ')') {
                    deque.pop();
                } else {
                    deque.add(s.charAt(i));
                }
            }
            if (!deque.isEmpty()) {
                answer = false;
            }

            return answer;
        }
    }
}
