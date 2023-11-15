package bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1259_팰린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            String answer = "yes";
            if (N == 0) break;
//            if(Integer.toString(N).length()%2==0) {
//                System.out.println("no");
//                continue;ㄹ
//            }
            for (int i = 0; i < Integer.toString(N).length() / 2; i++) {
                if (Integer.toString(N).charAt(i) != Integer.toString(N).charAt(Integer.toString(N).length() - i - 1)) {
                    answer = "no";
                    break;
                }

            }
            System.out.println(answer);
        }
    }
}
