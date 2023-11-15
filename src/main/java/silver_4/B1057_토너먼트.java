package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1057_토너먼트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int people = Integer.parseInt(arr[0]);
        int num1 = Integer.parseInt(arr[1]);
        int num2 = Integer.parseInt(arr[2]);
        int answer = 0;
        while (true) {
            num1 = num1 % 2 + num1 / 2;
            num2 = num2 % 2 + num2 / 2;
            answer++;
            if (num1 == num2) break;
        }
        System.out.println(answer);
    }
}
