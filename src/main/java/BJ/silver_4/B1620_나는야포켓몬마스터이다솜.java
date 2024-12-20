package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class B1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //포켓몬 수
        int M = Integer.parseInt(input[1]);

        HashMap<String, String> H = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            H.put(Integer.toString(i), br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (H.containsKey(name)) list.add(H.get(name)); //숫자로 주어질 때.
            else if (H.containsValue(name)) { //이름으로 주어질 때.
                for (String k : H.keySet()) {
                    if (H.get(k).equals(name)) list.add(k);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));
    }
}
