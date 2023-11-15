package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class B20291_파일정리하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> H = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("\\.");
            if (H.containsKey(input[1])) {
                H.put(input[1], H.get(input[1]) + 1);
            } else H.put(input[1], 1);
        }
        for (String j : H.keySet()) list.add(j);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
            System.out.println(H.get(list.get(i)));

        }
    }
}
