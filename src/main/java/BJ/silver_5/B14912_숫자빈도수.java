package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14912_숫자빈도수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int answer = 0;
        for (int i = 1; i <= Integer.parseInt(arr[0]); i++) {
            int num = i;
            while (true) {
                if (num == 0) break;
                if (num % 10 == Integer.parseInt(arr[1])) {
                    answer++;

                }
                num = num / 10;
            }
        }
        System.out.println(answer);
    }
}
