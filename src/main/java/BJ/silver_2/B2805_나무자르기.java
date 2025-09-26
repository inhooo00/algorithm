package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2805_나무자르기 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int startNum = arr[arr.length-1];
        int left = 0;
        int right = startNum;
        int answer = 0;
        while (left <= right){
            int mid = (left+right)/2;
            if (check(mid)){
                answer = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        System.out.println(answer);
    }

    private static boolean check(int mid) { // 큰지 확인
        long count =0;
        for(int num : arr){
            if (num>mid){
                count += num-mid;
            }
        }
        return count >= M;
    }
}
