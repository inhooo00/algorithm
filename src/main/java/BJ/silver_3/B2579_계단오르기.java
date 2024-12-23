package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(arr[1]);
        } else if (N == 2) {
            System.out.println(arr[1] + arr[2]);

        } else {
            answer[1] = arr[1];
            answer[2] = arr[1] + arr[2];
            answer[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);

            for (int i = 4; i <= N; i++) {
                answer[i] = Math.max(answer[i - 3] + arr[i] + arr[i - 1], answer[i - 2] + arr[i]);
            }
            System.out.println(answer[N]);
        }

    }
}
