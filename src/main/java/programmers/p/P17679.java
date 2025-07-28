package programmers.p;
import java.util.*;

public class P17679 {


    class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] charBoard = new char[m][n];
            boolean[][] check = new boolean[m][n];

            for (int i = 0; i < board.length; i++) {
                charBoard[i] = board[i].toCharArray();
            }

            while (true) {
                boolean found = false;

                for (int i = 0; i < m - 1; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        char c = charBoard[i][j];
                        if (c == '0') continue;
                        if (c == charBoard[i][j + 1] &&
                                c == charBoard[i + 1][j] &&
                                c == charBoard[i + 1][j + 1]) {
                            check[i][j] = true;
                            check[i][j + 1] = true;
                            check[i + 1][j] = true;
                            check[i + 1][j + 1] = true;
                            found = true;
                        }
                    }
                }

                if (!found) break;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (check[i][j]) {
                            charBoard[i][j] = '0';
                            answer++;
                        }
                    }
                }

                // 블록 떨어뜨리기
                for (int j = 0; j < n; j++) {
                    List<Character> column = new ArrayList<>();
                    for (int i = m - 1; i >= 0; i--) {
                        if (charBoard[i][j] != '0') {
                            column.add(charBoard[i][j]);
                        }
                    }
                    int row = m - 1;
                    for (char c : column) {
                        charBoard[row--][j] = c;
                    }
                    while (row >= 0) {
                        charBoard[row--][j] = '0';
                    }
                }

                for (int i = 0; i < m; i++) {
                    Arrays.fill(check[i], false);
                }
            }

            return answer;
        }
    }

}
