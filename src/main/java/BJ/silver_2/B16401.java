package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

///
// 첫째 줄에 조카의 수 M (1 ≤ M ≤ 1,000,000), 과자의 수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
//
//둘째 줄에 과자 N개의 길이 L1, L2, ..., LN이 공백으로 구분되어 주어진다. 과자의 길이는 (1 ≤ L1, L2, ..., LN ≤ 1,000,000,000) 를 만족한다.
//
// 첫째 줄에 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 출력한다.
//
//단, 모든 조카에게 같은 길이의 막대과자를 나눠줄 수 없다면, 0을 출력한다.
// 3 10
//1 2 3 4 5 6 7 8 9 10
// -> 8
public class B16401 {
    static int M, N;
    static long[] snackLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        M = Integer.parseInt(num[0]); // 조카 수
        N = Integer.parseInt(num[1]); // 막대 과자 수
        snackLen = new long[N]; // 막대 과자 길이
        String[] len = br.readLine().split(" ");

        long maxlen = 0;
        for (int i = 0; i < len.length; i++) {
            snackLen[i] = Long.parseLong(len[i]);
            maxlen = Math.max(maxlen, Long.parseLong(len[i]));
        }
        System.out.println(paraMetrix(1, maxlen));
    }

    private static long paraMetrix(long left, long right) {
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private static boolean check(long mid) { // 막대길이를 만족하는지 체크하는 함수
        int count = 0; // 조카 수
        for (int i = 0; i < N; i++) {
            if (snackLen[i] / mid == 0) {
                continue;
            }
            count += snackLen[i] / mid;
        }
        if (count >= M) {
            return true;
        }
        return false;
    }
}
