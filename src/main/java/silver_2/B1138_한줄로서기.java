package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B1138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr_S = br.readLine().split(" ");
        int[] arr = new int[N + 1];//

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(arr_S[i - 1]);
        }

        for (int i = N; i >= 1; i--) {
            list.add(arr[i], i);
        }

        for (int k : list) {
            System.out.print(k + " ");
        }


    }
}
