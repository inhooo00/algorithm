package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S16504_gravity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            br.readLine();
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int count = 0;
            int now = input[0];
            for (int num : input) {
                if (now < num) {
                    now = num;
                } else if (now > num) {
                    count++;
                }
            }
            System.out.println("#" + (i + 1) + " " + count);
        }
    }
}
