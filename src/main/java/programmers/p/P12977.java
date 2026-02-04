package programmers.p;

public class P12977 {
    public static void main(String[] args) {
        // Test the solution
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        int result = solution.solution(nums);
        System.out.println("Result: " + result);
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (isPrime_fun(nums[i] + nums[j] + nums[k])) {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }

    static boolean isPrime_fun(int n) {
        if (n==0){
            return false;
        }

        boolean[] isPrime;
        isPrime = new boolean[n + 1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime[n];
    }

//    static boolean isPrime(int n) { // 시간복잡도 O(N)
//        if (n < 2) {
//            return false; // 1은 소수가 아니기에 false
//        } else {
//            for (int i = 2; i < n; i++) {
//                if (n % i == 0) {
//                    return false; // 나머지연산을 했을 때 0이 나오면 소수가 아니므로 false
//                }
//            }
//            return true; // 위의 case
//        }
//    }
}
