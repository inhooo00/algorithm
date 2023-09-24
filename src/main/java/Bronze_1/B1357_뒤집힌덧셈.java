package Bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1357_뒤집힌덧셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String num1 = "";
        String num2 = "";
        for (int i = input[0].length() - 1; i >= 0; i--) {
            num1 += input[0].charAt(i);
        }
        for (int i = input[1].length() - 1; i >= 0; i--) {

            num2 += input[1].charAt(i);
        }
        String num3 = Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
        String answer = "";
        for (int i = num3.length() - 1; i >= 0; i--) {
            if (num3.charAt(i) == '0' && i == num3.length() - 1) continue;
            answer += num3.charAt(i);
        }
        System.out.println(answer);


    }
}
