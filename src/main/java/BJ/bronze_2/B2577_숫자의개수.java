package BJ.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2577_숫자의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());
        int sum = num1 * num2 * num3;
        int[] answer = new int[10];
        int NN = Integer.toString(sum).length();
        for (int i = 0; i < NN; i++) {
            int N = sum % 10;
            sum = sum / 10;
            answer[N]++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(answer[i]);

        }
    }
}
