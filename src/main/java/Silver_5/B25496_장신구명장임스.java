package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B25496_장신구명장임스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int P = Integer.parseInt(arr[0]); // 현재 피로도
        int N = Integer.parseInt(arr[1]); //만들 수 있는 개수
        String[] js = br.readLine().split(" ");
        int count = 0;
        int num = 0;
        int[] answer = new int[js.length];
        for (int i = 0; i < answer.length; i++) answer[i] = Integer.parseInt(js[i]);
        Arrays.sort(answer);
        while (true) {
            if (P >= 200) break;
            if (num == N - 1) {
                count++;
                break;
            }
            P += answer[num];
            num++;
            count++;
        }
        System.out.println(count);
    }
}
