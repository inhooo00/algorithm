package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 0에 가장 가까운 용액 조합하기.
// 오름차순으로 두 용액 반환.
public class B2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        while (start < end){
            int now = arr[start] + arr[end];
            //System.out.println(now);
            if (Math.abs(now) < min){
                min = Math.abs(now);
                answer[0] = arr[start];
                answer[1] = arr[end];
            }
            if (now < 0) start++;
            else end--;
        }
        System.out.println(answer[0] +" " + answer[1]);
    }
}