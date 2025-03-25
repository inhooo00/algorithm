package programmers.p;

import java.util.Arrays;

public class P42891 {

    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;
        System.out.println(new Solution().solution(food_times, k));
    }

    static class Solution {
        public int solution(int[] food_times, long k) {

            Arrays.sort(food_times);

            if ((long) food_times[0] * food_times.length <= k) {
                k -= (long) food_times[0] * food_times.length; // k에서 차감
                for (int i = 0; i < food_times.length; i++) {
                    food_times[i] -= food_times[0]; // 모든 음식에서 최소값 차감
                }
            }
            System.out.println(Arrays.toString(food_times));

            int i = 0;
            while (k > 0) {
                if (food_times[i] > 0) {
                    food_times[i]--;
                    k--;
                }

                i = (i + 1) % food_times.length;

            }

            while (food_times[i] == 0) {
                i = (i + 1) % food_times.length;
            }

            return i + 1;
        }
    }
}
