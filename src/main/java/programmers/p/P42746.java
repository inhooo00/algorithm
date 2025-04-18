package programmers.p;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class P42746 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {6, 10, 2};
        System.out.println(solution.solution(numbers));
    }


    static public class Solution {
        public String solution(int[] numbers) {
            StringBuilder answer = new StringBuilder();
            String[] strings = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                strings[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(strings, Collections.reverseOrder());
            System.out.println(Arrays.toString(strings));
            if (strings[0].equals("0")) return "0";

            for (String s : strings) answer.append(s);

            return answer.toString();
        }
    }
}
