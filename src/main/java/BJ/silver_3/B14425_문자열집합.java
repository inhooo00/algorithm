package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B14425_문자열집합 {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        String[] main = new String[Integer.parseInt(S[0])];
        String[] compare = new String[Integer.parseInt(S[1])];

        for (int i = 0; i < Integer.parseInt(S[0]); i++) main[i] = br.readLine();
        for (int i = 0; i < Integer.parseInt(S[1]); i++) compare[i] = br.readLine();

        for (int i = 0; i < Integer.parseInt(S[1]); i++) {
            for (int j = 0; j < Integer.parseInt(S[0]); j++) {
                if (main[j].compareTo(compare[i]) == 0) answer++;
            }
        }

        System.out.println(answer);
    }
}
