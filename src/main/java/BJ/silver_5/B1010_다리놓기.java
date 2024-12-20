package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B1010_다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        BigInteger[] answer = new BigInteger[count];
        for (int c=0;c<count;c++){
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[0]);
            BigInteger num1 = BigInteger.ONE;
            BigInteger num2 = BigInteger.ONE;
            for (int i = 0; i < M; i++) {
                num1 = num1.multiply(new BigInteger(String.valueOf(N - i)));
                num2 = num2.multiply(new BigInteger(String.valueOf(i + 1)));
            }

            answer[c] = num1.divide(num2); //나눈 값 저장
        }

        for (int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }


    }
}
