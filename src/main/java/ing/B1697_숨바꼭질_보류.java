package ing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예제 입력 1
//5 17
//예제 출력 1
//4(5-10-9-18-17 )
//x+1 or x-1 or x*2
public class B1697_숨바꼭질_보류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]); //수빈이 위치
        int K = Integer.parseInt(arr[1]); // 동생 위치
        int count = 0;

        while (true) {
            if (N==K) break;

            if (N * 2 < K) N *= 2;
            else if (N * 2 > K) {

                }
            count++;
            }
        System.out.println(count);

    }
}
