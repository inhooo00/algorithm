package BJ.gold_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 줄을 오름차순으로 세우는데 최소 횟수로 세우기
// 음..
public class B7570_줄세우기 {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(input[i]);
        }


    }
}
