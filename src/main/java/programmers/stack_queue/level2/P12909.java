package programmers.stack_queue.level2;

//s	answer
//"()()"	true
//"(())()"	true
//")()("	false
//"(()("	false
public class P12909 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }

        public static boolean solution(String s) {
            int openCount = 0;  // 여는 괄호 개수
            int closeCount = 0; // 닫는 괄호 개수

            if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
                for (char c : s.toCharArray()) {
                    if (c == '(') {
                        openCount++;
                    } else if (c == ')') {
                        closeCount++;
                    }

                    // 여는 괄호 개수보다 닫는 괄호 개수가 더 많으면 올바르지 않은 괄호 문자열
                    if (closeCount > openCount) {
                        return false;
                    }
                }

                // 여는 괄호와 닫는 괄호 개수가 동일하면 올바른 괄호 문자열
                return openCount == closeCount;
            }

            return false;
        }

}
