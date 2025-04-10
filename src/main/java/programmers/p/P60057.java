package programmers.p;

import java.util.ArrayDeque;

public class P60057 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aabbaccc";
        System.out.println(solution.solution(s));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;
            String string;
            for (int i = 0; i < s.length(); i++) {
                string = s;

                for (int j = 0; j < s.length() / (i + 1); j++) {
                    String sSub = s.substring(j, j + i + 1);
                    int idx = j+i+1;
                    while (true) {

                    }
                }
            }
            return answer;
        }
    }
}
