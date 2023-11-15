package bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2231_분해합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N; i++) { //200번
            int answer = i;
            String S = Integer.toString(answer);
            for (int j = 0; j < S.length(); j++) {
                answer += S.charAt(j)-'0';
            }
            if (answer == N)
                list.add(i);
        }
        Collections.sort(list);
        if (list.isEmpty()) System.out.println(0);
        else System.out.println(list.get(0));
    }
}