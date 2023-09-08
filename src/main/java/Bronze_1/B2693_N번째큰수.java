package Bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2693_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int Arr[] = new int[10];
        int answer[] = new int[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" "); //
            int[] st = new int[10]; //
            for (int j = 0; j < 10; j++) st[j] = Integer.parseInt(s[j]);
            Arrays.sort(st);
            answer[i] = st[7];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }

    }
}
