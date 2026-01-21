package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][2]; // [0]시 부터 [1]시 까지
        for (int i = 0; i < N; i++) {
            String[] input2 = br.readLine().split(" ");
            field[i][0] = Integer.parseInt(input2[0]);
            field[i][1] = Integer.parseInt(input2[1]);
        }

        // 회의실배정
        Arrays.sort(field, (a,b)-> {
            if (a[1]==b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int nowNum = field[0][1];
        int count = 1;
        for (int i = 0; i < N-1; i++) {
            if (nowNum <= field[i+1][0]){
                count++;
                nowNum =field[i+1][1];
            }
        }
        System.out.println(count);
    }
}
