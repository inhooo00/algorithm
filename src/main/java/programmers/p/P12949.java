package programmers.p;

public class P12949 {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4,1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        Solution solution = new Solution();
        int[][] result = solution.solution(arr1, arr2);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            for (int i = 0; i < arr1.length; i++) {
                for (int k = 0; k < arr2[0].length; k++) {
                    for (int j = 0; j < arr1[0].length; j++) {
                        answer[i][k] += arr1[i][j] * arr2[j][k];
                    }
                }
            }
            return answer;
        }
    }
}
