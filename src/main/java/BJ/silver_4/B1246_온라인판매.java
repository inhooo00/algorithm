package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1246_온라인판매 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); //달걀
        int S = Integer.parseInt(input[1]); //고객
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < S; i++) list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        int count = 0;
        int max = 0;
        for (int i = 0; i < S; i++) {
            int midsum = 0;
            int num = list.get(i);
            if (S - i < N) midsum = num * (S - i); //사람 수보다 달걀이 많을 때.
            else midsum = num * N; // 사람 수보다 달걀이 적을 때.
            if (max < midsum) {
                max = midsum;
                count = num;
            }

        }
        System.out.printf(count + " " + max);
    }
}
