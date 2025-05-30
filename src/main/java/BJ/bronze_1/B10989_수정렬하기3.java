package BJ.bronze_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.TreeMap;

public class B10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }
}
