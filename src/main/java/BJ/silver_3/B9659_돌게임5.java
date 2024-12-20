package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9659_돌게임5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = N % 2;
        if (answer%2==1) {
            System.out.println("SK");
        } else System.out.println("CY");
    }
}
