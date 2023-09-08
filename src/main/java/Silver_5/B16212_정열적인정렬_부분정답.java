package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B16212_정열적인정렬_부분정답 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        String[] arr_S = br.readLine().split(" ");
        int[] arr_I = new int[S];
        for (int i = 0; i < S; i++) arr_I[i] = Integer.parseInt(arr_S[i]);
        Arrays.sort(arr_I);
        for (int i=0;i<S-1;i++) System.out.print(arr_I[i]+" ");
        System.out.print(arr_I[S-1]);

    }
}
