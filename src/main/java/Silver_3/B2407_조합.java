package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B2407_조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;
        for (int i = 0; i < M; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(N - i)));
            num2 = num2.multiply(new BigInteger(String.valueOf(i + 1)));
        }

        BigInteger answer = num1.divide(num2); //나눈 값 저장

        System.out.println(answer);

    }
}
