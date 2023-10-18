package Bronze_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11718_그대로출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            System.out.println(input);
        }
    }
}
