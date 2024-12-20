package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//예제 입력 2
//6

//5
//7
//9
//8492
//8493
//192398
//예제 출력 2
//2
// 5 7 9 8492 8493 192398
public class B1337_올바른배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);

        int num = 0;
        for (int i = 0; i < N; i++) {
            int answer = 0;
            for (int j = 1; j < 5; j++) {
                if (!list.contains(list.get(i) + j)) answer++;
            }
            arr[i] = answer;

        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
