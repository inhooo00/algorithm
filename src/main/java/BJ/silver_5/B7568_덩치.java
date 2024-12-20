package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//5
//55 185
//58 183
//88 186
//60 175
//46 155
public class B7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] S = new String[N][2];

        for (int i = 0; i < N; i++) {
            String[] array = br.readLine().split(" ");
            S[i][0] = array[0];
            S[i][1] = array[1];
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(S[i][0]) < Integer.parseInt(S[j][0]) && Integer.parseInt(S[i][1]) < Integer.parseInt(S[j][1]))
                    count++;
            }
            System.out.println(count);
        }
    }
}
