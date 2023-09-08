package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1059_좋은구간 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); //집합 크기
        String[] S = br.readLine().split(" ");
        int[] arr = new int[L];
        for (int i = 0; i < L; i++) arr[i] = Integer.parseInt(S[i]);
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 1001;
        for (int i : arr) {
            if (i < n) {
                if (i > start) start = i;
            } else if (i > n) {
                if (i < end) end = i;
            } else {
                System.out.println(0);
                return;
            }
        }
        //System.out.println(start+ " " + end);
        int answer = 0;
        for (int i = start + 1; i <= n; i++) {
            for (int j = n; j <= end - 1; j++) {
                if (i != j) answer++;
            }
        }
        System.out.println(answer);
    }
}
