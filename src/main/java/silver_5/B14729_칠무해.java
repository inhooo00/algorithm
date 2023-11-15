package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B14729_칠무해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) arr[i] = Double.parseDouble(br.readLine());

        Arrays.sort(arr);


        for (int i = 0; i < 7; i++) System.out.printf("%.3f%n", arr[i]);
    }
}
