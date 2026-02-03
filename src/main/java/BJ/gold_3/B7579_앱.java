package BJ.gold_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B7579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] arr = new int[N][2];
        String[] input2 = br.readLine().split(" ");
        String[] input3 = br.readLine().split(" ");

        for (int i = 0; i < 5; i++) {
            arr[i][0] = Integer.parseInt(input2[i]);
            arr[i][1] = Integer.parseInt(input3[i]);
        }

        // M이사 확보하면서 매모리는 가장 적게

    }
}
