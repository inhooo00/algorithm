package BJ.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10870_피보나치수5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(fi(input));

    }

    static int fi(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fi(n - 1) + fi(n - 2);
    }
}
