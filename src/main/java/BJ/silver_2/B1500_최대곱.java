package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1500_최대곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int S = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        long max = 1; //곱해야 하니 1 초기화
        int num1 = S / K;
        int num2 = S % K;

        for (int i = 1; i <= K; i++) {
            if (num2 >= i) max *= (num1 + 1);
            else max *= num1;
        }
        System.out.println(max);
    }
}
