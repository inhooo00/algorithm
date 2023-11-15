package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int answer = K;
        int count = 0;

        while (true) {
            if (answer == 0) break;

            for (int i = N - 1; i >= 0; i--) {
                // System.out.println(i);
                if (answer - list.get(i) >= 0) {
                    answer = answer - list.get(i);
                    count++;
                    break;
                }

            }
        }
        System.out.println(count);
    }
}
