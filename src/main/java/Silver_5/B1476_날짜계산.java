package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1476_날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");
        int E = 1;
        int S = 1;
        int M = 1;
        int count = 1;
        while (true) {
            if (Integer.parseInt(string[0]) == E && Integer.parseInt(string[1]) == S && Integer.parseInt(string[2]) == M)
                break;
            E++;
            S++;
            M++;
            count++;
            if (E == 16) E = 1;
            if (S == 29) S = 1;
            if (M == 20) M = 1;
        }
        System.out.println(count);
    }
}
