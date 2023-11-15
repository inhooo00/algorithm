package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1789_수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int sum = 0;
        int count = 0;
        for (int i = 1; ; i++) {
            sum += i;
            if (sum > N) break;
            count++;
        }
        System.out.println(count);
    }
}
