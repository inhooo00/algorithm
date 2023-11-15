package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1100_하얀칸 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for (int i = 0; i < 8; i++) {
            String[] arr = br.readLine().split("");
            if (i % 2 == 0) { //홀수
                for (int j = 0; j < 8; j += 2) {
                    if (arr[j].equals("F")) answer++;
                }
            } else for (int j = 1; j < 8; j += 2) {
                if (arr[j].equals("F")) answer++;
            }

        }
        System.out.println(answer);
    }
}
