package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> H = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (H.containsKey(input[i])) H.put(input[i], H.get(input[i]) + 1);
            else H.put(input[i], 1);
        }
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            H.putIfAbsent(input2[i], 0);
            System.out.print(H.get(input2[i]) + " ");
        }
    }
}
