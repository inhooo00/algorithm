package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9658_돌게임4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long answer = N % 7;
        if (answer == 1 || answer == 3) {
            System.out.println("CY");
        } else System.out.println("SK");
    }
}
