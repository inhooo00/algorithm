package programmers.p;

import java.util.Stack;

public class P1835 {

    public static void main(String[] args) {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
        Solution solution = new Solution();
        int result = solution.solution(n, data);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int n, String[] data) {
            int answer = 0;
            String[] arr = {"A", "C", "F", "J", "M", "N", "R", "T"};

            Stack<String> stack = new Stack<>();
            stack.push("");

            while (!stack.isEmpty()) {
                String current = stack.pop();

                if (current.length() == 8) {
                    boolean valid = true;

                    for (String condition : data) {
                        char c1 = condition.charAt(0);
                        char c2 = condition.charAt(2);
                        char op = condition.charAt(3);
                        int value = condition.charAt(4) - '0';

                        int pos1 = current.indexOf(c1);
                        int pos2 = current.indexOf(c2);
                        int distance = Math.abs(pos1 - pos2) - 1;

                        if ((op == '=' && distance != value) ||
                                (op == '<' && distance >= value) ||
                                (op == '>' && distance <= value)) {
                            valid = false;
                            break;
                        }
                    }

                    if (valid) {
                        answer++;
                    }
                    continue;
                }

                for (int i = 0; i < 8; i++) {
                    if (!current.contains(arr[i])) {
                        stack.push(current + arr[i]);
                    }
                }
            }

            return answer;
        }
    }
}
