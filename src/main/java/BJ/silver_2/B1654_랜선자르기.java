package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 가장 긴 값으로 시작 -> 이분탐색
// 나온 값으로 랜선들을 나눠서 M의 길이와 딱 맞는 경우로 진행..
public class B1654_랜선자르기 {
    static int N,M;
    static List<Integer> list = new ArrayList<>();
    static int maxNum;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        //System.out.println(list);
        list.sort((a,b)->b-a);
        maxNum = list.get(0);

        //System.out.println(maxNum);
        long left = 1;
        long right = maxNum;
        long answer = 0;

        while (left <= right){
            long mid = (right+left) /2;
            long count = search(mid);

            if (count >=M){
                answer = mid;
                left = mid+1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    private static long search(long nowNum) {
        long count = 0;
        for(int N : list){
            count += N/nowNum;
        }
        return count;
    }
}
