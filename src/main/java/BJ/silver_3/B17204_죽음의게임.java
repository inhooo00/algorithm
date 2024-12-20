package BJ.silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//예제 입력 1
//5 3
//1
//3
//2
//1
//4
//예제 출력 1
//2
public class B17204_죽음의게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        int N = Integer.parseInt(S[0]);
        int K = Integer.parseInt(S[1]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(br.readLine()));

        int count = 1;
        int num = list.get(0);
        while (count != N) {
            if (num == K) {
                break;
            }
            num = list.get(num);
            count++;
        }
        if (count == N) {
            System.out.println(-1);
        } else System.out.println(count);
    }
}
