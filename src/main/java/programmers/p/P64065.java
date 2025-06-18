package programmers.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P64065 {

    public static void main(String[] args) {
        // Example usage
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        Solution solution = new Solution();
        Integer[] result = solution.solution(s);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    static class Solution {
        public Integer[] solution(String s) {
            String[] arr = s.substring(2, s.length() - 2).split("},\\{");
            Arrays.sort(arr, Comparator.comparingInt(String::length));
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                String[] arr2 = arr[i].split(",");
                for (int j = 0; j < arr2.length; j++) {
                    if (!list.contains(Integer.parseInt(arr2[j]))) {
                        list.add(Integer.parseInt(arr2[j]));
                        break;
                    }
                }
            }

            return list.toArray(new Integer[0]);
        }
    }
}
