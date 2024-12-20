package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B25757_임스와함께하는미니게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        String w = input[1];

        HashMap<String, Integer> H = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            H.put(name, 1);
        }
        if (w.equals("Y")) System.out.println(H.size());
        else if (w.equals("F")) System.out.println(H.size() / 2);
        else System.out.println(H.size() / 3);
    }
}
