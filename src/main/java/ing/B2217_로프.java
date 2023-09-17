package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine())); //리스트 저장
        Collections.sort(list); // 오름차순 정렬
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, list.get(i) * (N - i));
        }
        System.out.println(max);
    }
}
