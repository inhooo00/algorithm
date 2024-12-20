package BJ.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B27160_할리갈리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> H = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String f = input[0];
            int num = Integer.parseInt(input[1]);
            if (!H.containsKey(f)) H.put(f, num);
            else H.put(f, H.get(f) + num);
        }
            if (H.containsValue(5)) System.out.println("YES");
            else System.out.println("NO");
    }
}
