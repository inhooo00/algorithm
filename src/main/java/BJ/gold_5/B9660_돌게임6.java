package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9660_돌게임6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = N % 7;
        if (answer == 2 || answer == 0) {
            System.out.println("CY");
        } else System.out.println("SK");
    }
}
