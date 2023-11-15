package silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//예제 입력 1 1씩 증가
//3 10
//10 11 13
//예제 출력 1
//12
public class B16435_스네이크버드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int L = Integer.parseInt(arr[1]);
        List<Integer> list = new ArrayList<>();
        String[] arr_2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(arr_2[i]));
        Collections.sort(list);

        int num = 0;
        int answer = L;
        while (true) {
            if (num == list.size() - 1 && answer >= list.get(num)) {
                answer++;
                break;
            }
            if (answer < list.get(num)) break;
            answer++;
            num++;


        }
        System.out.println(answer);
    }
}
