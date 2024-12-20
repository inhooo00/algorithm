package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class B16165_걸그룹마스터준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        List<String> list = new ArrayList<>();
        int N = Integer.parseInt(input[0]); // 걸그룹 수
        int M = Integer.parseInt(input[1]); // 문제 수
        HashMap<String, String> H = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int members = Integer.parseInt(br.readLine());
            for (int j = 0; j < members; j++) {
                String name = br.readLine();
                H.put(name, teamName);
            }
        }
        for (int i = 0; i < M; i++) {
            list.clear();
            String name = br.readLine();
            int number = Integer.parseInt(br.readLine());
            if (number == 1) System.out.println(H.get(name));
            else {
                for (String j : H.keySet()) {
                    if (H.get(j).equals(name)) {
                        list.add(j);
                    }
                }
                Collections.sort(list);
                for (int j = 0; j < list.size(); j++) System.out.println(list.get(j));

            }
        }
    }
}
