package BJ.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 6개 고르기.
// 배열을 6개 쌓이면 그걸 sb에 쌓아서 누적하기
public class B6603_로또 {
    static StringBuilder sb;
    static int[] numList;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            sb = new StringBuilder();
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0")) break;
            arr = new int[input.length-1];
            for (int i = 1; i < input.length; i++) {
                arr[i-1] = Integer.parseInt(input[i]);
            }
            numList = new int[6];

            dfs(0,0);
            System.out.println(sb);
        }
    }

    private static void dfs(int depth, int start) {
        if (depth ==6){
            for(int num : numList) {
                sb.append(num +" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=start;i<arr.length;i++){ // arr만큼 순회
            numList[depth] = arr[i];
            dfs(depth+1,1+i);
        }
    }
}
