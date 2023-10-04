package Bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface B1075_나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        int num = N / 100 * 100;
        int answer = 00;
        while (true) {
            if (num % F == 0) break;
            answer = ++num;
        }
        if (Integer.toString(answer % 100).length() == 1) {
            System.out.println(0 + "" + answer % 100);
        } else System.out.println(answer % 100);
    }
}
