package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 물병 N개로 K물병 만들기
// 같은 양의 물들만 합칠 수 있음.
// 2 제곱을 끝까지 가서 모든 물병 분리.
// K기준 마지막 리스트 값 - 나머지 전체 값
public class B1052_물병 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int answer = 0;
        if (N <= K) {
            System.out.println(0);
            System.exit(0);
        }
        // 2진수로 나타낼 때 1의 개수를 줄이자.
        while (true){
            if (Integer.bitCount(N) > K){
                N++;
                answer++;
                continue;
            }
            break;
        }
        System.out.println(answer);

    }

}
