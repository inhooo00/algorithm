package BJ.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1817_짐챙기는숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        int N = Integer.parseInt(S[0]); // 개수
        int M = Integer.parseInt(S[1]); //상한선
        if (N == 0) System.out.println(0);
        else {
            Queue<Integer> Q = new LinkedList<>();
            String[] arr_S = br.readLine().split(" ");
            for (int i = 0; i < arr_S.length; i++) Q.add(Integer.parseInt(arr_S[i])); //Q에 값 저장
            int answer = 0;
            while (!Q.isEmpty()) {
                if (Q.size() == 1) {
                    answer++;
                    break;
                }
                int count = Q.poll();
                if (count + Q.peek() > M) {
                    answer++;
                } else if (count + Q.peek() <= M) { // 두 개의 값이 M값에 미치지 못 할 때
                    while (true) {
                        count += Q.poll();
                        if (Q.size() > 0 && count + Q.peek() > M) break;
                        else if (Q.size() == 0) break;
                    }
                    answer++;
                }
            }
            System.out.println(answer);


        }

    }
}
