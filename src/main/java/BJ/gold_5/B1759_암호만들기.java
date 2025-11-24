package BJ.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 암호는 L개의 알파벳으로 구성.
// 최소 한 개의 모음(a, e, i, o, u) + 최소 두 개의 자음/
// 증가하는 배열
public class B1759_암호만들기 {
    static String[] mo = {"a", "e", "i", "o", "u"};
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        arr = new String[C];
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            arr[i] = input2[i];
        }
        Arrays.sort(arr);
        // 오름차순이잖아. 그럼 순열임. 조합이 아님. visited가 아닌 start로 처리해야함.
        String[] list = new String[L];
        dfs(0, 0, list);

        System.out.println(sb);
    }

    private static void dfs(int depth, int start, String[] list) {
        if (depth == L) {
            int moCount = 0;
            for (int i = 0; i < list.length; i++) {
                for (String m : mo) {
                    if (list[i].equals(m)) {
                        moCount++;
                    }
                }
            }
            if (moCount >= 1 && L-moCount >= 2) {
                for (String s : list) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            list[depth] = arr[i];
            dfs(depth + 1, i + 1, list);
        }
    }
}
