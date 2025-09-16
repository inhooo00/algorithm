package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1759_암호만들기 {
    // 정렬을 해놓고
    // 배열에 하나씩 쌓다가
    // N개가 되면 나오고 sb에 append하기.
    static int N,M;
    static char[] charArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = array[0];
        M = array[1];
        String[] arr = br.readLine().split(" ");
        Arrays.sort(arr, (a,b)->a.charAt(0) - b.charAt(0));
        charArr = new char[M];
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = arr[i].charAt(0);
        }

        for (int i = 0; i <= M-N; i++) { // 시작 문자
            dfs(i + 1, 1, String.valueOf(charArr[i]), isMo(charArr[i]) ? 1 : 0, isMo(charArr[i]) ? 0 : 1);
        }
        System.out.println(sb);
    }

    private static void dfs(int start, int depth, String current, int moCount, int jaCount) {
        if (depth == N) {
            if (moCount >= 1 && jaCount >= 2) {
                sb.append(current).append("\n");
            }
            return;
        }

        for (int i = start; i < M; i++) {
            char ch = charArr[i];
            if (isMo(ch)) {
                dfs(i + 1, depth + 1, current + ch, moCount + 1, jaCount);
            } else {
                dfs(i + 1, depth + 1, current + ch, moCount, jaCount + 1);
            }
        }
    }

    private static boolean isMo(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
