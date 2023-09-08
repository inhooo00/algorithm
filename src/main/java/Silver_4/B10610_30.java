package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//예제 입력 4
//80875542
//예제 출력 4
//88755420
// 30의 배수
// 각 자리들의 합이 3의 배수며 끝이 0인 경우를 구하면 된다.
public class B10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int[] arr_int = new int[arr.length];
        int S = 0;
        for (int i = 0; i < arr.length; i++) {
            arr_int[i] = Integer.parseInt(arr[i]);
            S += Integer.parseInt(arr[i]);
        }

        Arrays.sort(arr_int);

        if (arr_int[0] == 0 && S % 3 == 0) {
            for (int i = 0; i < arr.length; i++) System.out.print(arr_int[arr.length - 1 - i]);
        } else System.out.println(-1);
    }
}
