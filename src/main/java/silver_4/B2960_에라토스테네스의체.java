package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예제 입력 1
//7 3
//예제 출력 1
//6
public class B2960_에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = new int[N + 1];
        for (int i = 2; i <= N; i++) arr[i] = i;
        for (int i = 2; i <= N; i++) {
            if (arr[i] == 0) continue;
            for (int j = i; j <= N; j += i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    K--;
                }
                if (K == 0) {
                    System.out.println(j);
                    return;
                }

            }
        }

    }
}
