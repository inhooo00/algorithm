package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] arr = {64, 32, 16, 8, 4, 2, 1};
        int answer = 0;
        int num = 0;
        int count = 0;
        while (answer != X) {
            if (X - answer >= arr[num]) {
                answer += arr[num];
                count++;
            }
            num++;
        }
        System.out.println(count);

    }
}
