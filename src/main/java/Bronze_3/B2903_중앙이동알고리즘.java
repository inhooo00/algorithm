package Bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2903_중앙이동알고리즘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(Math.pow(2, N) +1, 2));
    }
}
