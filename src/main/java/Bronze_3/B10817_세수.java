package Bronze_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10817_세수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] arr_I = new int[3];
        for (int i = 0; i < 3; i++) arr_I[i] = Integer.parseInt(arr[i]);
        Arrays.sort(arr_I);
        System.out.println(arr_I[1]);
    }
}
