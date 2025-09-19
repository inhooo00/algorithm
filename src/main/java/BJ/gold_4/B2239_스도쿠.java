//package BJ.gold_4;
//
//// 9*9 스도쿠 문제..
//// 가로 세로 확인. 대각선 확인.... 각 필드 확인..
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class B2239_스도쿠 {
//    static int[][] field = new int[9][9];
//    static int[][] rows = {
//            {-1,0},
//            {1,0},
//            {0,1},
//            {0,-1},
//            {-1,-1}, //오른쪽 아래 방향
//            {1,1},
//            {-1,1}, // 왼쪽 아래 방향
//            {1,-1}
//    };
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int i = 0; i < 9; i++) {
//            String[] arr = br.readLine().split("");
//            for (int j = 0; j < 9; j++) {
//                field[i][j] = Integer.parseInt(arr[j]);
//            }
//        }
//
//        while (true) {
//            boolean jud = false;
//            for (int i = 0; i < 9; i++) {
//                for (int j = 0; j < 9; j++) {
//                    if (field[i][j]==0){
//                        dfs(i,j);
//                        jud = true;
//                    }
//                }
//            }
//            if(!jud) break;
//        }
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(field[i][j]);
//            }
//            System.out.println();
//        }
//
//    }
//
//    private static void dfs(int x, int y) { //
//        for(int[] row : rows){
//            int nx = x;
//            int ny = y;
//            while (true){
//                nx += row[0];
//                ny += row[1];
//                if(nx<0||ny<0||nx>=9||ny>=9){
//                    break;
//                }
//
//                if (field[nx][ny] == field[x][y]) {
//                    copy[nx][ny] = 7;
//                }
//            }
//        }
//    }
//
//}
