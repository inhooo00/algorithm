package BJ.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//예제 입력 1
//6
//9
//2 7 4 1 5 3 -> 1 2 3 4 5 7
//예제 출력 1
//2
public class B1940_주몽 {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //개수
        int M = Integer.parseInt(br.readLine()); // 2개 합친 값
        String[] S = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(S[i]);
        Arrays.sort(arr); //오름차순 정렬

        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr.length - 1;
            while (true) {
                if (i >= a) break;
                if (arr[i] + arr[a] < M) break; // 둘의 합이 M보다 작으면 종료
                else if (arr[i] + arr[a] == M) {
                    answer++; //둘의 합이 M과 같으면 answer++
                    break;
                }
                a--;
            }
        }
        System.out.println(answer);

    }
}
