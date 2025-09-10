package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B1182_부분수열의합 {
    // 개수 상관 없이 전부 더한 값이 S와 같으면 +1.
    // 5개에 도착하면 그대로 return
    static int answer = 0;
    static List<Integer> list = new ArrayList<>();
    static int N, S;
    static int[] 입력받은수;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        S = Integer.parseInt(arr[1]);
        입력받은수 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(0,0);
        if(S==0)answer--;
        System.out.println(answer);
    }

    private static void dfs(int sum, int depth) {
        if(sum==S) answer++;

        for (int i = depth; i < N; i++) {
            dfs(sum+입력받은수[i],i+1);
        }
    }
}
/*
 0
 -7 1

 */