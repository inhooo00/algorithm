package programmers.p;

public class P67256 {

    // 1 2 3
    // 4 5 6
    // 7 8 9
    //   0

    // 0 1 2
    // 3 4 5
    // 6 7 8
    //   10

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, hand));
    }

    static class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int l = 9, r = 11;

            for (int number : numbers) {
                if (number == 1 || number == 4 || number == 7) {
                    l = number;
                    answer += "L";
                } else if (number == 3 || number == 6 || number == 9) {
                    r = number;
                    answer += "R";
                } else {
                    int leftD = 계산식;
                    int rightD = 계산식;
                    if (leftD < rightD) {
                        l = number;
                        answer += "L";
                    } else if (leftD > rightD) {
                        r = number;
                        answer += "R";
                    } else if (hand.equals("right")) {
                        r = number;
                        answer += "R";
                    } else {
                        l = number;
                        answer += "L";
                    }
                }
            }
            return answer;
    }
}
}
