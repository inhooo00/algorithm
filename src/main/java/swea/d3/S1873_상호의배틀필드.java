package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//. 평지(전차가 들어갈 수 있다.)
//*	벽돌로 만들어진 벽 -> 포탄 맞으면 평지
//#	강철로 만들어진 벽 -> 못부심
//-	물(전차는 들어갈 수 없다.)
//^	위쪽을 바라보는 전차(아래는 평지이다.)
//v	아래쪽을 바라보는 전차(아래는 평지이다.)
//<	왼쪽을 바라보는 전차(아래는 평지이다.)
//>	오른쪽을 바라보는 전차(아래는 평지이다.)

//U   Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
public class S1873_상호의배틀필드 {
    static int H,W,N;
    static String[][] FIELD;
    static String[] ORDER;
    static int[] START;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            String[] input = br.readLine().split(" ");
            H = Integer.parseInt(input[0]);
            W = Integer.parseInt(input[1]);
            FIELD = new String[H][W];
            START = new int[2];
            for (int j = 0; j < H; j++) {
                String[] input2 = br.readLine().split("");
                for (int k = 0; k < W; k++) {
                    FIELD[j][k] = input2[k];
                    if (FIELD[j][k].equals("^") ||FIELD[j][k].equals("v")||FIELD[j][k].equals("<")||FIELD[j][k].equals(">")){
                        START[0] = j;
                        START[1] = k;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            ORDER = br.readLine().split("");
            //System.out.println(Arrays.deepToString(FIELD));
            //System.out.println(Arrays.toString(ORDER));
            for (int j = 0; j < ORDER.length; j++) { // 시뮬 진행
                play(ORDER[j]);
            }
            System.out.print("#"+i+" ");
            for (int j = 0; j < FIELD.length; j++) {
                for (int k = 0; k < FIELD[0].length; k++) {
                    System.out.print(FIELD[j][k]);
                }
                System.out.println();
            }
        }
    }

    //U   Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
//D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
//L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
//R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
//S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
    private static void play(String order) {

        int x = START[0];
        int y = START[1];
        if (order.equals("U")){
            FIELD[x][y] = "^";
            if (x-1 < 0) return;
            if (FIELD[x-1][y].equals(".")){
                START[0] = x-1;
                FIELD[x-1][y] = "^";
                FIELD[x][y] = ".";
            }
        }else if (order.equals("D")){
            FIELD[x][y] = "v";
            if (x+1 >= H) return;
            if (FIELD[x+1][y].equals(".")){
                START[0] = x+1;
                FIELD[x+1][y] = "v";
                FIELD[x][y] = ".";
            }
        }else if (order.equals("L")){
            FIELD[x][y] = "<";
            if (y-1 < 0) return;
            if (FIELD[x][y-1].equals(".")){
                START[1] = y-1;
                FIELD[x][y-1] = "<";
                FIELD[x][y] = ".";
            }
        }else if (order.equals("R")){
            FIELD[x][y] = ">";
            if (y+1 >= W) return;
            if (FIELD[x][y+1].equals(".")){
                START[1] = y+1;
                FIELD[x][y+1] = ">";
                FIELD[x][y] = ".";
            }
        }else if (order.equals("S")){
            if (FIELD[x][y].equals("^")){
                int newX = x-1;
                int newY = y;
                while (true){
                    if (newX < 0) break;
                    if (FIELD[newX][newY].equals("*")) {
                        FIELD[newX][newY] = ".";
                        break;
                    }
                    else if (FIELD[newX][newY].equals("#")) break;
                    newX--;
                }
            }else if (FIELD[x][y].equals("v")){
                int newX = x+1;
                int newY = y;
                while (true){
                    if (newX >= H) break;
                    if (FIELD[newX][newY].equals("*")) {
                        FIELD[newX][newY] = ".";
                        break;
                    }
                    else if (FIELD[newX][newY].equals("#")) break;
                    newX++;
                }
            }else if (FIELD[x][y].equals("<")){
                int newX = x;
                int newY = y-1;
                while (true){
                    if (newY < 0) break;
                    if (FIELD[newX][newY].equals("*")) {
                        FIELD[newX][newY] = ".";
                        break;
                    }
                    else if (FIELD[newX][newY].equals("#")) break;
                    newY--;
                }
            }else if (FIELD[x][y].equals(">")){
                int newX = x;
                int newY = y+1;
                while (true){
                    if (newY >= W) break;
                    if (FIELD[newX][newY].equals("*")) {
                        FIELD[newX][newY] = ".";
                        break;
                    }
                    else if (FIELD[newX][newY].equals("#")) break;
                    newY++;
                }
            }
        }
    }
}
// 보는 방향으로 포탄 쏘기