package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class B15665_N과M11 {
    static int N, M;
    static int[] arr1; // 정답 누적
    static int[] intArr; // 주어진 배열
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        intArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted()
                .toArray();
        arr1 = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();

            for (int n : arr1) {
                sb2.append(n).append(" ");
            }
            if(set.add(sb2.toString())){
                for (int n : arr1) {
                    sb.append(n).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
                arr1[depth] = intArr[i];
                dfs(depth + 1);
            }

        }
    }
