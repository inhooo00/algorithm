package Bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B7567_그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        String S = input[0];
        int answer = 10;
        for (int i=1;i<input.length;i++){
            if(S.equals(input[i])) answer+=5;
            else answer+=10;
            S= input[i];
        }
        System.out.println(answer);
    }
}
