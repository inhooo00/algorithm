package programmers.p;

public class P12913 {

    public static void main(String[] args) {
        // Example usage
        int[][] land = {
            {1, 2, 3, 5},
            {5, 6, 7, 8},
            {4, 3, 2, 1},
            {2, 3, 4, 5}
        };
        Solution solution = new Solution();
        int result = solution.solution(land);
        System.out.println("Maximum sum: " + result);
    }

    static class Solution {
        int solution(int[][] land) {
            // 같은 행은 못 밟고 내려옴.
            // 최대값을 찾아야함 - 같은 값들이 여러 개 있을 텐데 , 뭘 밟고 내려오냐에 따라서 최대값이 달라질 듯.

            int answer = 0;

            for (int i = 1; i < land.length; i++) {
                land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
                land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
                land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
                land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
            }

            answer = Math.max(Math.max(land[land.length-1][0], land[land.length-1][1]), Math.max(land[land.length-1][2], land[land.length-1][3]));
            return answer;
        }
    }
}
