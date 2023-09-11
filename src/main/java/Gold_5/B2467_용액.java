package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//예제 입력 1
//5
//-2 4 -99 -1 98
//예제 출력 1
//-99 98
public class B2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(arr[i]));
        Collections.sort(list); //오름차순 정렬

        int[] answer = new int[2]; // 답 도출
        int n = 0;
        int t = N - 1;
        int col = Integer.MAX_VALUE;
        while (n < t) {
            int sum = list.get(n) + list.get(t);

            if (Math.abs(sum) < col) {
                col = Math.abs(sum);
                answer[0] = list.get(n);
                answer[1] = list.get(t);
                if (sum == 0) break;
            }
            if (sum < 0) n++;
            else t--;


        }
        System.out.println(answer[0] + " " + answer[1]);

    }
}
// -99 -2 -1 4 98