package programmers.p;

public class P12918 {
    public static void main(String[] args) {

        Solution solution = new P12918().new Solution();
        System.out.println(solution.solution("1234")); // true
        System.out.println(solution.solution("12345")); // false
        System.out.println(solution.solution("123a")); // false
        System.out.println(solution.solution("123456")); // true
    }
    class Solution {
        public boolean solution(String s) {
            boolean answer = false;
            if ((s.length()==4 || s.length() ==6)){
                answer = true;
            }
            if (s.matches(".*[a-zA-Z].*")){
                answer = false;
            }
            return answer;
        }
    }
}
