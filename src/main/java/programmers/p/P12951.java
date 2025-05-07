package programmers.p;

import java.util.Arrays;

public class P12951 {

    public static void main(String[] args) {
        String s = "  for the last week";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            String answer = "";
            String sToLow = s.toLowerCase();
            String[] arr = sToLow.split(" ", -1);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() > 0) {
                    answer += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
                }
                if (i < arr.length - 1) {
                    answer += " ";
                }
            }

            return answer;
        }
    }
}
