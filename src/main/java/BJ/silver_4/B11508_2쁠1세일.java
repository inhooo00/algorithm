package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B11508_2쁠1세일 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        int num = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            answer += arr[i];
        }
        for (int i = 0; i < n / 3; i++) {
            num += arr[2 + (i * 3)];
        }
        answer -= num;
        System.out.println(answer);

    }
}
