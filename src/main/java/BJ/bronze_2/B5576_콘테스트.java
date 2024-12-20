package BJ.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        List<Integer> juc = new ArrayList<>();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 20; i++) list.add(Integer.parseInt(br.readLine())); // 20개 받고

        for (int i = 0; i < 10; i++) {
            juc.add(list.get(i));
        }
        Collections.sort(juc);
        for (int i = 7; i < 10; i++) sum1 += juc.get(i);
        juc.clear();

        for (int i = 10; i < 20; i++) {
            juc.add(list.get(i));
        }
        Collections.sort(juc);
        for (int i = 7; i < 10; i++) sum2 += juc.get(i);
        System.out.println(sum1 + " " + sum2);

    }
}
