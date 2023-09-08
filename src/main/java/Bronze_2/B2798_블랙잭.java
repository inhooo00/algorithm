package Bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//예제 입력 1
//5 21
//5 6 7 8 9
//예제 출력 1
//21
public class B2798_블랙잭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        String[] number = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int answer = Integer.parseInt(number[i]) + Integer.parseInt(number[j]) + Integer.parseInt(number[k]);
                    if (answer <= M) list.add(answer);
                }
            }

        }
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.get(0));

    }
}
