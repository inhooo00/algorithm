package programmers.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P155652 {

    public static void main(String[] args) {

        Solution solution = new P155652().new Solution();
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String result = solution.solution(s, skip, index);
        System.out.println(result);
    }

    class Solution {
        public String solution(String s, String skip, int index) {
            String[] alp = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                    "s", "t", "u", "v", "w", "x", "y", "z"};
            String answer = "";
            List<String> alpList = new ArrayList<>(Arrays.asList(alp));
            String[] sArr = s.split("");
            String[] skipArr = skip.split("");
            for (String string : skipArr) {
                alpList.remove(string);
            }
            System.out.println(alpList);
            for (String string : sArr) {
                int lastIndex = (alpList.indexOf(string) + index) % (alpList.size());
                answer += alpList.get(lastIndex);
                System.out.println(alpList.get(lastIndex));
            }
            return answer;
        }
    }
}
