package programmers.p;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class P49994 {
    public static void main(String[] args) {

        String dirs = "LULLLLLLU";
        Solution solution = new Solution();
        int result = solution.solution(dirs);
        System.out.println(result); // Expected output: 7
    }

    static class Solution {

        public static int solution(String dirs) {
            HashSet<String> visited = new HashSet<>();
            int currentX = 0, currentY = 0;

            for (char d : dirs.toCharArray()) {
                int nextX = currentX;
                int nextY = currentY;

                if (d == 'U') nextY++;
                else if (d == 'D') nextY--;
                else if (d == 'R') nextX++;
                else if (d == 'L') nextX--;

                if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5) continue;

                String path;
                if (currentX < nextX || (currentX == nextX && currentY < nextY)) {
                    path = currentX + "," + currentY + "-" + nextX + "," + nextY;
                } else {
                    path = nextX + "," + nextY + "-" + currentX + "," + currentY;
                }

                visited.add(path);

                currentX = nextX;
                currentY = nextY;
            }

            return visited.size();
        }
    }
}
