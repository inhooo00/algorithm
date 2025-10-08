package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        // 단순히 뒤에 a 추가.
        // reverse 후 뒤에 b 추가.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length(); i++) {
            sb.append(b.charAt(i));
        }

        while (sb.length() > a.length()) {
            int now = sb.charAt(sb.length()-1);
            sb.delete(sb.length() - 1, sb.length());
            //System.out.println(now);
            if (now=='A') {
                continue;
            } else {
                sb.reverse();
            }
        }
        if (sb.toString().equals(a)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
