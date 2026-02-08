package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// M이진수표현 마지막 N자리수 모두 1인지 판단
public class S10726_이진수표현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <=T ; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int NB = (1 << (N))-1;
            if ((NB & M) == NB) {
                System.out.println("ON");
            } else {
                System.out.println("OFF");
            }

        }
    }
}
