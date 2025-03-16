package programmers.p;

public class P67256 {

    // 1 2 3
    // 4 5 6
    // 7 8 9
    // 10 11 12

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        Solution solution = new Solution();
        System.out.println(solution.solution(numbers, hand));
    }

    static class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int l = 10, r = 12;

            for (int number : numbers) {
                if (number == 1 || number == 4 || number == 7) {
                    l = number;
                    answer += "L";
                } else if (number == 3 || number == 6 || number == 9) {
                    r = number;
                    answer += "R";
                } else {
                    int leftD = getDistance(l,number);
                    int rightD = getDistance(r,number);
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

        private int getDistance(int current, int target) {
            if (current == 0) {
                current = 11;
            }
            if (target == 0) {
                target = 11;
            }

            int curRow = (current - 1) / 3;
            int curCol = (current - 1) % 3;

            int targetRow = (target - 1) / 3;
            int targetCol = (target - 1) % 3;

            return Math.abs(curRow - targetRow) + Math.abs(curCol - targetCol);
        }
    }
}
