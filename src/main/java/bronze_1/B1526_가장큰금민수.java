package bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1526_가장큰금민수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        while (true) {
            boolean b = true;
            for (int i = 0; i < S.length(); i++) { //숫자 판별
                if (S.charAt(i) != '7' && S.charAt(i) != '4') { // 각 자리가 7또는 4면
                    b = false;
                    break;
                }
            }
            if (b) break;
            else S = String.valueOf(Integer.parseInt(S) - 1);
        }

        System.out.println(S);
    }
}
