package jobda;

public class OmokJudge {
    static final int SIZE = 19;
    static int[][] board = new int[SIZE][SIZE];

    // 방향: →, ↓, ↘, ↗
    static int[][] directions = {
            {0, 1},  // →
            {1, 0},  // ↓
            {1, 1},  // ↘
            {-1, 1}  // ↗
    };

    public static int judge(int[][] black, int[][] white) {
        // 보드 초기화
        for (int[] row : board) {
            java.util.Arrays.fill(row, 0);
        }

        // 흑은 1, 백은 2로 표시
        for (int[] p : black) {
            board[p[0] - 1][p[1] - 1] = 1;
        }
        for (int[] p : white) {
            board[p[0] - 1][p[1] - 1] = 2;
        }

        if (hasWon(1)) return 1;   // 흑 승
        if (hasWon(2)) return -1;  // 백 승
        return 0;                  // 아무도 이기지 않음
    }

    private static boolean hasWon(int player) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != player) continue;
                for (int[] dir : directions) {
                    int dx = dir[0], dy = dir[1];
                    int count = 1;
                    int x = i, y = j;

                    // 5개 탐색
                    for (int k = 0; k < 4; k++) {
                        x += dx;
                        y += dy;
                        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) break;
                        if (board[x][y] != player) break;
                        count++;
                    }

                    // 정확히 5개이고 양끝이 같은 색이 아님
                    if (count == 5) {
                        int px = i - dx, py = j - dy;
                        if (px >= 0 && px < SIZE && py >= 0 && py < SIZE && board[px][py] == player)
                            continue;
                        int nx = x + dx, ny = y + dy;
                        if (nx >= 0 && nx < SIZE && ny >= 0 && ny < SIZE && board[nx][ny] == player)
                            continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

//    public static int[] findWinningMoveForBlack() {
//        int[] bestMove = {-1, -1};
//
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (board[i][j] != 0) continue;
//
//                board[i][j] = 1; // 흑을 임시로 둬봄
//                if (hasWon(1)) {
//                    if (bestMove[0] == -1 || i < bestMove[0] || (i == bestMove[0] && j < bestMove[1])) {
//                        bestMove[0] = i;
//                        bestMove[1] = j;
//                    }
//                }
//                board[i][j] = 0; // 되돌림
//            }
//        }
//
//        if (bestMove[0] != -1) {
//            bestMove[0]++;
//            bestMove[1]++;
//        }
//
//        return bestMove;
//    }
    // 테스트용 main
    public static void main(String[] args) {
        int[][] B = {
                {10,10},{10,11},{8,10},{9,10},{6,10},{11,10},{7,10}
        };
        int[][] W = {
                {9,11},{10,12},{11,13},{12,10},{5,10},{12,14}
        };
        System.out.println(judge(B, W)); // 출력: 0
    }
}

// 승부가 안 난 상태에서
// + 흑이 어디에 두면 이길지
// 답이 여러개면 가장 작은 인덱스로, 답이 없으면 -1-1 반환.