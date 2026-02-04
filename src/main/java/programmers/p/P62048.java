package programmers.p;

public class P62048 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 12));
    }

    static class Solution {
        public long solution(int w, int h) {

            return w * h - (w + h - gcd(w, h));
        }

        static int gcd(int a, int b) {
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            return a;
        }

//        static int lcm(int a, int b) {
//            return a * b / gcd(a, b);
//        }
    }
}
