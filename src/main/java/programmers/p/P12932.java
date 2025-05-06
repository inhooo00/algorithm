package programmers.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import programmers.p.P12929.Solution;

public class P12932 {

    // 자연수 n이 주어질 때, n의 각 자리 숫자를 큰 수부터 작은 수로 정렬한 새로운 자연수를 리턴하는 함수, solution을 완성해주세요.

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(54255555)));
    }

    static class Solution {
        public Long[] solution(long n) {
            String[] arr = new String[String.valueOf(n).length()];
            for (int i = 0; i < String.valueOf(n).length(); i++) {
                arr = String.valueOf(n).split("");
            }
            Long[] result = new Long[String.valueOf(n).length()];
            for (int i = 0; i < arr.length; i++) {
                result[i] = Long.parseLong(arr[arr.length - i - 1]);
            }
            return result;
        }
    }
}
