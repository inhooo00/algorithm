package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 한빈이가 과자 2개 골랐을 때 최대 무게
public class S9229_한빈이와SpotMart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] snk = new int[N];
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < snk.length; j++) {
                snk[j] = Integer.parseInt(input2[j]);
            }
            Arrays.sort(snk);
            int start = 0;
            int end = N-1;
            int answer = -1;
            while(start < end){
                if (snk[start] + snk[end] <= M){
                    answer = Math.max(snk[start] + snk[end], answer);
                    start++;
                }else end --;

            }
            System.out.println("#"+i+" "+answer);

        }
    }
}
