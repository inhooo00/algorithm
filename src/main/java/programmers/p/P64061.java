package programmers.p;

public class P64061 {

    // 움직였을 때 2개 같은 숫자가 쌓이면 사라짐.
    // 터진 개수 결과 반환.
    // 먼저 moves.length만큼 순회를 하며 그 칸에 맞는 숫자를 누적해감
    // 뺀 곳은 0으로 채우고
    // 그 뒤에 만들어진 리스트에서 중복된 값은 없앤다. 그러면서 answer +2
    // 중복을 어떻게 없앨까? 바로 생각나는 건 replaceAll로 11 22 33 44 55 찾기.
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution solution = new Solution();
        System.out.println(solution.solution(board, moves));
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            String result = "";

            for (int num : moves) {
                for (int j = 0; j < 5; j++) {
                    if (board[j][num - 1] != 0) {
                        result += (board[j][num - 1]);
                        board[j][num - 1] = 0;
                        break;
                    }
                }
            }
            int resultLen = result.length(); // 기존 결과 리스트 길이

            String[] arr = {"11", "22", "33", "44", "55"};
            while (true) {
                String resultCopy = result;
                for (int i = 0; i < arr.length; i++) { // 겹치는 거 있는지 확인하고 없애기
                    result = result.replaceAll(arr[i], "");
                }
                if (resultCopy.equals(result)) {
                    break;
                }
            }
            answer = resultLen - result.length();
            return answer;
        }
    }
}
