package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11004_K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int count = Integer.parseInt(s[0]); //총 수
        int K = Integer.parseInt(s[1]); //몇번째
        String[] arr_S = br.readLine().split(" ");
        int[] arr_int = new int[arr_S.length];
        for (int i = 0; i < arr_S.length; i++) arr_int[i] = Integer.parseInt(arr_S[i]);
        Arrays.sort(arr_int);

        System.out.println(arr_int[K - 1]);


    }
}
