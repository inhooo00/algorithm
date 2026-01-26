package BJ.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2437_저울 {
    static int[] arr; // 숫자들
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        if (arr[0] != 1) {
            System.out.println(1);
            return;
        }

        int total = arr[0];
        for(int i=1; i<arr.length;i++){
            if (total+1 >= arr[i]) total += arr[i];
            else {
                System.out.println(total+1);
                return;
            }
        }
        System.out.println(total+1);

    }
}
