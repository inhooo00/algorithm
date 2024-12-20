package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int count = 1;
        for (int i = 0; i < N.length() - 1; i++) {
            if (N.charAt(i) != N.charAt(i + 1)) count++;
        }
        if (count == 1) System.out.println(0);
        else System.out.println(count / 2);
    }
}
