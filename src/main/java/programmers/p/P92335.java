package programmers.p;

import java.util.Arrays;

public class P92335 {

    public static void main(String[] args) {
        Solution solution = new P92335().new Solution();
        int n = 110011;
        int k = 10;
        int result = solution.solution(n, k);
        System.out.println("Result: " + result); // Expected output: 3
    }

    class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            String string = Integer.toString(n, k);
            String[] arr = string.split("0");

            for (int i = 0; i < arr.length; i++) {
                if (isPrime(arr[i]) && !string.isEmpty()) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean isPrime(String num) {
            double n;
            try {
                n = Double.parseDouble(num);
            } catch (NumberFormatException e) {
                return false;
            }

            if (n <= 1) return false;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }

    }
}
