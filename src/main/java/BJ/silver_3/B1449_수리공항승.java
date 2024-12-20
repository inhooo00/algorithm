package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B1449_수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int L = Integer.parseInt(arr[1]);
        String[] arr_2 = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(arr_2[i]));

        Collections.sort(list);
        int answer = 0;
        int tap = 0;
        for (int i = 0; i < N; i++) {
            if (list.get(i) > tap) {
                answer++;
                tap = list.get(i);
                tap += L - 1;
            }
        }
        System.out.println(answer);
    }
}
