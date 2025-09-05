package BJ.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //테스트 개수
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 스티커 개수
            String[][] sticker = new String[2][n];
            sticker[0] = br.readLine().split(" ");
            sticker[1] = br.readLine().split(" ");

            if(n==1){
                System.out.println(Math.max(Integer.parseInt(sticker[1][0]),Integer.parseInt(sticker[0][0])));
                continue;
            }
            int[][] max1 = new int[2][n]; // 첫 번째
            max1[0][0] = Integer.parseInt(sticker[0][0]);
            max1[1][0] = Integer.parseInt(sticker[1][0]);
            for (int j = 1; j < n; j++) {
                max1[0][j] = Math.max(max1[0][j - 1], max1[1][j - 1] + Integer.parseInt(sticker[0][j]));
                max1[1][j] = Math.max(max1[0][j - 1] + Integer.parseInt(sticker[1][j]), max1[1][j - 1]);
            }

            // 0,1은 0,0 vs 1,0 + 0,1
            // 1,1은 1,0 vs 0,0 + 1,1
            int[][] max2 = new int[2][n]; // 두 번째
            max2[0][0] = Integer.parseInt(sticker[0][1]);
            max2[1][0] = Integer.parseInt(sticker[1][1]);
            max2[0][1] = Integer.parseInt(sticker[0][1]);
            max2[1][1] = Integer.parseInt(sticker[1][1]);
            for (int j = 2; j < n; j++) {
                max2[0][j] = Math.max(max2[0][1], max2[1][j - 1] + Integer.parseInt(sticker[0][j]));
                max2[1][j] = Math.max(max2[0][j - 1] + Integer.parseInt(sticker[1][j]), max2[1][j - 1]);
            }

            System.out.println(Math.max(
                    Math.max(max1[0][max1[0].length-1],max1[1][max1[0].length-1]),
                    Math.max(max2[0][max2[0].length-1],max2[1][max2[0].length-1])
                    )
            );
        }
    }
}
